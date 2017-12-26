package com.quimera.corptextiljt.service.impl;

import java.util.List;

import com.quimera.corptextiljt.model.Acceso;
import com.quimera.corptextiljt.model.dao.AccesoDAO;
import com.quimera.corptextiljt.service.ServiceAcceso;

public class ServiceAccesoImpl implements ServiceAcceso {

	public AccesoDAO accesoDAO;
	
	@Override
	public void add(Acceso bean) {
		accesoDAO.add(bean);		
	}

	@Override
	public void delete(Acceso bean) {
		accesoDAO.delete(bean);
		
	}

	@Override
	public List<Acceso> getListAcceso(Acceso bean) {
		return accesoDAO.getListAcceso(bean);
	}

	@Override
	public Acceso getAcceso(Acceso bean) {
		return accesoDAO.getAcceso(bean);
	}

	public void setAccesoDAO(AccesoDAO accesoDAO) {
		this.accesoDAO = accesoDAO;
	}

}
