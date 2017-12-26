package com.quimera.corptextiljt.model.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.quimera.corptextiljt.model.Acceso;
import com.quimera.corptextiljt.model.dao.AccesoDAO;

public class AccesoDAOImpl extends AbstractDAO<Acceso, Integer> implements AccesoDAO  {

	public AccesoDAOImpl() {
		
		super(Acceso.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void add(Acceso bean) {
		super.update(bean);
		
	}

	@Override
	public void delete(Acceso bean) {
		super.delete(bean);
		
	}

	@Override
	public List<Acceso> getListAcceso(Acceso bean) {
		
		return super.getListByFilter(bean);
	}

	@Override
	public Acceso getAcceso(Acceso bean) {
		// TODO Auto-generated method stub
		return super.getByFilter(bean);
	}


	@Override
	protected void buildCriteria(DetachedCriteria criteria, Acceso filter) {
		if (filter.getIdacceso() != null) {
			criteria.add(Restrictions.eq("idacceso", filter.getIdacceso()));
		}
		
	}


	@Override
	protected void buildCriteria(DetachedCriteria criteria, Acceso filter, Integer id) {
		// TODO Auto-generated method stub
		
	}

}
