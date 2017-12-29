package com.quimera.corptextiljt.service;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/context.xml","/dataAccess.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceProducto {

	@Autowired
	private ServiceProducto serviceProducto;
	

	@Test
	public void Test01ListProduct (){
		List<Producto> list = serviceProducto.getListProducto(new Producto());
		System.out.println(list);
	}

	@Test
	public void Test02GetListByIdProduct (){
		List<Precioproducto> list = serviceProducto.getLastPrecioProductoByTipo(new Precioproducto(), 1);
		System.out.println(list);
	}
	
}
