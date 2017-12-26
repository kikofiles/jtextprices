package com.quimera.corptextiljt.service;

import java.util.List;

import com.quimera.corptextiljt.model.Acceso;

public interface ServiceAcceso {

	public void add(Acceso bean);
	public void delete (Acceso bean);
	public List<Acceso> getListAcceso (Acceso bean);
	public Acceso getAcceso (Acceso bean);
}
