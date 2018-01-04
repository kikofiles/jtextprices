package com.quimera.corptextiljt.zk.usuario;

import java.util.List;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Button;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.service.ServiceProducto;
import com.quimera.corptextiljt.service.ServicePrecioProducto;
import com.quimera.corptextiljt.service.context.SpringApplicationContext;
import com.quimera.corptextiljt.util.Constants;
import java.math.BigDecimal;



public class ControlAltaUsuario extends Window{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Textbox idTxtNombreUsuario;
	private Textbox idTxtApodo;
	private Textbox idTxtContra;
	private Combobox idCmbTipoUsuario;
	private Combobox idCmbTiendaAsignada;
	private Button idBtnCancelar;
	private Button idBtnGuardar;
	
	
	public void initializeContext() {
		initializeComponentes();
		
	}
	
	private void initializeComponentes() {	
		idTxtNombreUsuario = (Textbox) getFellow("idNombreUsuario");
		idTxtApodo = (Textbox) getFellow("idUsuario");
		idTxtContra = (Textbox) getFellow("idPasswordUser");
		idCmbTipoUsuario = (Combobox) getFellow("idTipoUsuario");
		idCmbTiendaAsignada = (Combobox) getFellow("idTiendaAsignada");
		idBtnCancelar = (Button) getFellow("idBotonCancelar");
		idBtnGuardar = (Button) getFellow("idBotonGuardar");
	}
	
}
