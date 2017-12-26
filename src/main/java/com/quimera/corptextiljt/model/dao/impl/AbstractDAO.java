package com.quimera.corptextiljt.model.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




public abstract class AbstractDAO <T,PK extends Serializable> extends HibernateDaoSupport implements GenericDAO<T,PK>{
	private Class<T> type;
	
	public AbstractDAO(Class<T> type) {
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see org.cimmyt.cril.apps.sampletracking.core.persistence.dao.GenericDAO#create(java.lang.Object)
	 */
	@Override
	public T create(T newInstance) {
		getHibernateTemplate().save(newInstance);
		return newInstance;
	}

	/* (non-Javadoc)
	 * @see org.cimmyt.cril.apps.sampletracking.core.persistence.dao.GenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(T persistentObject) {
		getHibernateTemplate().delete(persistentObject);
	}

	public void deleteWithOutSession(T persistentObject){
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
		getHibernateTemplate().delete(persistentObject);
		getHibernateTemplate().getSessionFactory().getCurrentSession().flush();
	}
	/* (non-Javadoc)
	 * @see org.cimmyt.cril.apps.sampletracking.core.persistence.dao.GenericDAO#read(java.io.Serializable)
	 */
	@Override
	public T read(PK id) {
		T result = (T)getHibernateTemplate().get(type, id);
		getHibernateTemplate().initialize(result);
		//return (T)getHibernateTemplate().get(type, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.cimmyt.cril.apps.sampletracking.core.persistence.dao.GenericDAO#update(java.lang.Object)
	 */
	@Override
	public void update(T transientObject) {
		getHibernateTemplate().flush();
		getHibernateTemplate().saveOrUpdate(transientObject);
		getHibernateTemplate().flush();
	}
	

	public void updateWithoutSession(T transientObject){
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
		getHibernateTemplate().saveOrUpdate(transientObject);
		getHibernateTemplate().getSessionFactory().getCurrentSession().flush();
	}
	/**
	 * 
	 * @param filter
	 * @return
	 */
	@SuppressWarnings(value = { "unchecked", "deprecation" })
	public List<T> getListByFilter(final T filter) {
		List<T> resultList = null; 
		resultList = (List<T>) this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						DetachedCriteria criteria = DetachedCriteria.forClass(type);
						buildCriteria(criteria, filter);
						return getHibernateTemplate().findByCriteria(criteria);
					}

				});
		return resultList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getByFilter(final T filter) {
		T resultList = null; 
		resultList = (T) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						DetachedCriteria criteria = DetachedCriteria.forClass(type);
						buildCriteria(criteria, filter);
						return getHibernateTemplate().findByCriteria(criteria);
					}

				});
		return resultList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getByFilterUnicValue(final T filter) {
		T resultList = null; 
		resultList = (T) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						DetachedCriteria criteria = DetachedCriteria.forClass(type);
						buildCriteria(criteria, filter);
						List<?> list = getHibernateTemplate().findByCriteria(criteria);
						if (list !=  null && !list.isEmpty())
						return getHibernateTemplate().findByCriteria(criteria).get(0);
						else 
							return null;
					}

				});
		return resultList;
	}

	public List<T> getListByFilter(final T filter,final Integer id) {
		return getListByFilter(filter, id, 0,0,null, true);
	}

	@SuppressWarnings(value = "unchecked")
	public List<T> getListByFilter(final T filter,final Integer id,final int firstResult,final int maxResults
			, final String sortColumn, final boolean ascending) {
		List<T> resultList = null; 
		resultList = this.getHibernateTemplate().execute(
				new HibernateCallback<List<T>>() {

					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						DetachedCriteria criteria = DetachedCriteria.forClass(type);
						
						if(!(sortColumn == null || sortColumn.isEmpty()))
							for(String sort : sortColumn.split("\\s*,\\s*"))
								criteria.addOrder( ascending ? Order.asc(sort) : Order.desc(sort));
						
						buildCriteria(criteria, filter, id);
						
						return (List<T>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
					}

				});
		return resultList;
	}
	
	public Integer getListByFilterTotal(final T filter,final Integer id){
		Integer numResults = null; 
		numResults = this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					@Override
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						DetachedCriteria criteria = DetachedCriteria.forClass(type);
						buildCriteria(criteria, filter, id);
						criteria.setProjection(Projections.rowCount());
						return (Integer)getHibernateTemplate().findByCriteria(criteria).get(0);
					}

				});
		return numResults;
	}
	
	public Integer getTotalRowsByFilter(final T filter,final Integer id) {
		Integer resultList = this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					@Override
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						DetachedCriteria criteria = DetachedCriteria.forClass(type);
						buildCriteria(criteria, filter, id);
						criteria.setProjection(Projections.rowCount());
						Object obj = getHibernateTemplate().findByCriteria(criteria).get(0);
						if (obj instanceof Long)
						return ((Long)getHibernateTemplate().findByCriteria(criteria).get(0)).intValue();
						else if (obj instanceof Integer)
							return (Integer)getHibernateTemplate().findByCriteria(criteria).get(0);
						else 
							return 0;
					}
				});
		return resultList;
	}
	public Integer getListByFilterTotalLong(final T filter,final Integer id){
		Integer numResults = null; 
		numResults = this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					@Override
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						DetachedCriteria criteria = DetachedCriteria.forClass(type);
						buildCriteria(criteria, filter);
						criteria.setProjection(Projections.rowCount());
						Object obj = getHibernateTemplate().findByCriteria(criteria).get(0);
						if (obj instanceof Long)
						return ((Long)getHibernateTemplate().findByCriteria(criteria).get(0)).intValue();
						else if (obj instanceof Integer)
							return (Integer)getHibernateTemplate().findByCriteria(criteria).get(0);
						else 
							return 0;
					}

				});
		return numResults;
	}
	/**
	 * Find single by values
	 * @param clazz
	 * @param properties
	 * @param values
	 * @return
	 * @throws Exception
	 */
	public  T findSingleByValues(T clazz, Object[] properties, Object[] values) throws Exception
    {
        
        if(properties.length != values.length)
        {
            throw new Exception("The number of properties must be the same than the number of values");
        }
        String strClazz = type.getSimpleName();
        StringBuilder builder = new StringBuilder("SELECT DISTINCT a FROM "+strClazz+" a"+ " WHERE ");
        for( int i = 0; i < values.length; i++ )
        {
            if(values[i] instanceof String)
            {
                builder.append( "a."+properties[i]+" LIKE ?" );
            }
            else
            {
                builder.append( "a."+properties[i]+" = ?" );
            }
            builder.append( " AND " );
        }
        String query = builder.toString().trim();
        if(StringUtils.endsWith( query, "AND" ))
        {
            query = StringUtils.removeEnd( query, "AND" );
        }
        @SuppressWarnings("unchecked")
		List<T> list= (List<T>)getHibernateTemplate().find( query, values );
        if(list != null && !list.isEmpty() )
        {
            return list.get( 0 );
        }
        else
        {
            return null;
        }  
    }
	/**
	 * Find single by values
	 * @param clazz
	 * @param properties
	 * @param values
	 * @return
	 * @throws Exception
	 */
	public  List<T> findListByValues(T clazz, Object[] properties, Object[] values) throws Exception
    {
        
        if(properties.length != values.length)
        {
            throw new Exception("The number of properties must be the same than the number of values");
        }
        String strClazz = type.getSimpleName();
        StringBuilder builder = new StringBuilder("FROM "+strClazz+" as a"+ " WHERE ");
        for( int i = 0; i < values.length; i++ )
        {
            if(values[i] instanceof String)
            {
                builder.append( "a."+properties[i]+" LIKE ?" );
            }
            else
            {
                builder.append( "a."+properties[i]+" = ?" );
            }
            builder.append( " AND " );
        }
        String query = builder.toString().trim();
        if(StringUtils.endsWith( query, "AND" ))
        {
            query = StringUtils.removeEnd( query, "AND" );
        }
        @SuppressWarnings("unchecked")
		List<T> list= (List<T>)getHibernateTemplate().find( query, values );
        if(list != null && !list.isEmpty() )
        {
            return list;
        }
        else
        {
            return null;
        }  
    }
	

	/**
	 * 
	 * @param criteria
	 * @param filter
	 */
	protected abstract void buildCriteria(DetachedCriteria criteria, final T filter);

	protected abstract void buildCriteria(DetachedCriteria criteria, final T filter, Integer id);

		
	@SuppressWarnings("unchecked")
	public  List<T> findListByQuery(T clazz, String queryString) 
    {
    
		try {
        	List<T> list = (List<T>)getHibernateTemplate().find(queryString);
        return list;
        }catch (HibernateException  ex){
        	
        	logger.error(ex.getMessage(), ex);
        	
        }catch(Exception exG){
        	exG.printStackTrace();
        	logger.error(exG.getMessage(), exG);
        	
        }finally {
        	
        } 
    	 return null;
    }

	@SuppressWarnings("unchecked")
	public T findGenericByQuery(T clazz, String queryString) 
    {
    
		try {
        	List<T> list = (List<T>)getHibernateTemplate().find(queryString);
        	if (list != null && !list.isEmpty()){
        		return list.get(0);
        	}
        	return null;
        }catch (HibernateException  ex){
        	
        	logger.error(ex.getMessage(), ex);
        	
        }catch(Exception exG){
        	exG.printStackTrace();
        	logger.error(exG.getMessage(), exG);
        	
        }finally {
        	
        } 
    	 return null;
    }
}
