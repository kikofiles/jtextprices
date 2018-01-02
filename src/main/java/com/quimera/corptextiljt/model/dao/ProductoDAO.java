package com.quimera.corptextiljt.model.dao;

import java.util.List;

import com.quimera.corptextiljt.model.Producto;

public interface ProductoDAO {

	public void add(Producto bean);
	public void delete (Producto bean);
	public List<Producto> getListProducto (Producto bean);
	public Producto getProducto (Producto bean);
}
