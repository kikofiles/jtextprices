package com.quimera.corptextiljt.service.impl;

import java.util.List;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.model.dao.PrecioproductoDAO;
import com.quimera.corptextiljt.model.dao.ProductoDAO;
import com.quimera.corptextiljt.service.ServicePrecioProducto;

public class ServicePrecioProductoImpl implements ServicePrecioProducto{

	private ProductoDAO productoDAO;
	private PrecioproductoDAO precioProductoDAO;
	
	@Override
	public void add(Producto bean) {
		productoDAO.add(bean);
		
	}
	
	public void add(Precioproducto bean) {
		precioProductoDAO.add(bean);
	}

	@Override
	public void delete(Precioproducto bean) {
		precioProductoDAO.delete(bean);
		
	}

	@Override
	public List<Producto> getListProducto(Producto bean) {
		return productoDAO.getListProducto(bean);
	}

	@Override
	public Producto getProducto(Producto bean) {
		return productoDAO.getProducto(bean);
	}


	@Override
	public List<Precioproducto> getLastPrecioProductoByTipo(Precioproducto bean , int idProducto) {
		// TODO Auto-generated method stub
		return precioProductoDAO.getLastPrecioProductoByTipo(bean, idProducto);
	}

	public void setPrecioproductoDAO(PrecioproductoDAO precioproductoDAO) {
		this.precioProductoDAO = precioproductoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	
	
}
