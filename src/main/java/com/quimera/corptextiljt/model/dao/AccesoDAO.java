package com.quimera.corptextiljt.model.dao;

import java.util.List;

import com.quimera.corptextiljt.model.Acceso;

public interface AccesoDAO {

	public void add(Acceso bean);
	public void delete (Acceso bean);
	public List<Acceso> getListAcceso (Acceso bean);
	public Acceso getAcceso (Acceso bean);
}
