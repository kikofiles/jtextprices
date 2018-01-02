package com.quimera.corptextiljt.service;

import java.util.List;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;

public interface ServicePrecioProducto {

	
	public void add (Producto bean);
	public void add (Precioproducto bean);
	public void delete (Precioproducto bean);
	public List<Producto> getListProducto (Producto bean);
	public Producto getProducto (Producto bean);
	public List<Precioproducto> getLastPrecioProductoByTipo (Precioproducto bean , int idProducto);
}
