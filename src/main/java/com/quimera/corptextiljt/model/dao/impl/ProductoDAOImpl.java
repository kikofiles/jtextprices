package com.quimera.corptextiljt.model.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.quimera.corptextiljt.model.Acceso;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.model.dao.ProductoDAO;

public class ProductoDAOImpl extends AbstractDAO<Producto, Integer> implements ProductoDAO{

	public ProductoDAOImpl (){
		super(Producto.class);
	}

	@Override
	public void add(Producto bean) {
		super.update(bean);
		
	}

	@Override
	public List<Producto> getListProducto(Producto bean) {
		
		return super.getListByFilter(bean);
	}

	@Override
	public Producto getProducto(Producto bean) {
		return super.getByFilter(bean);
	}

	@Override
	protected void buildCriteria(DetachedCriteria criteria, Producto filter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void buildCriteria(DetachedCriteria criteria, Producto filter, Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
