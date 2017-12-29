package com.quimera.corptextiljt.service.impl;

import java.util.List;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.model.dao.PrecioproductoDAO;
import com.quimera.corptextiljt.model.dao.ProductoDAO;
import com.quimera.corptextiljt.service.ServiceProducto;

public class ServiceProductoImpl implements ServiceProducto{

	private ProductoDAO productoDAO;
	private PrecioproductoDAO precioProductoDAO;
	
	@Override
	public void add(Producto bean) {
		productoDAO.add(bean);
		
	}

	@Override
	public void delete(Producto bean) {
		productoDAO.delete(bean);
		
	}

	@Override
	public List<Producto> getListProducto(Producto bean) {
		return productoDAO.getListAcceso(bean);
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

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public void setPrecioProductoDAO(PrecioproductoDAO precioProductoDAO) {
		this.precioProductoDAO = precioProductoDAO;
	}
	
	
}
