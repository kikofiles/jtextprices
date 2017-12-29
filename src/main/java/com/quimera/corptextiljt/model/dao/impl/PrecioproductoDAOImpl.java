package com.quimera.corptextiljt.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.dao.PrecioproductoDAO;

public class PrecioproductoDAOImpl extends AbstractDAO <Precioproducto , Integer> implements PrecioproductoDAO{

	public PrecioproductoDAOImpl (){
		super(Precioproducto.class);
	}

	@Override
	public void add(Precioproducto bean) {
		super.update(bean);
	}

	@Override
	public List<Precioproducto> getListPrecioproducto(Precioproducto bean) {
		return super.getListByFilter(bean);
	}

	@Override
	public Precioproducto getPrecioproducto(Precioproducto bean) {
		return super.getByFilter(bean);
	}

	@Override
	public List<Precioproducto> getLastPrecioProductoByTipo(Precioproducto bean ,int idProdcuto) {
		return super.getListByFilter(bean, idProdcuto);
	}

	@Override
	protected void buildCriteria(DetachedCriteria criteria, Precioproducto filter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void buildCriteria(DetachedCriteria criteria, Precioproducto filter, Integer id) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		criteria.add(Restrictions.eq("producto.idproducto", id));
		criteria.add(Restrictions.in("tipoprecio.idtipoPrecio", list));
		
		criteria.addOrder(Order.desc("tienda.idtienda"));
		criteria.addOrder(Order.desc("fechaMod"));
		
	}
}
