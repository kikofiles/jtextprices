package com.quimera.corptextiljt.model.dao;

import java.util.List;

import com.quimera.corptextiljt.model.Precioproducto;

public interface PrecioproductoDAO {
	

	public void add (Precioproducto bean);
	public void delete (Precioproducto bean);
	public List<Precioproducto> getListPrecioproducto (Precioproducto bean);
	public Precioproducto getPrecioproducto (Precioproducto bean);
	public List<Precioproducto> getLastPrecioProductoByTipo (Precioproducto bean, int idProdcuto);
}
