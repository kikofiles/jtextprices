package com.quimera.corptextiljt.zk.usuario;




import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Combobox;

import java.math.BigDecimal;

import org.zkoss.zul.Button;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.service.ServiceProducto;
import com.quimera.corptextiljt.service.ServicePrecioProducto;
import com.quimera.corptextiljt.service.context.SpringApplicationContext;
import com.quimera.corptextiljt.util.Constants;




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
	
	
	// Proceso de almacenamiento de Usuario
	public void guardaUsuario() {
		System.out.println("Entre a Guarda Usuario...");
		// Primero checo que hayan puesto el nombre Completo del Usuario
		if(idTxtNombreUsuario.getValue().trim() != null && idTxtNombreUsuario.getValue().trim().length()>0) {
			// Segundo checo los valores de Nickname y Password
			if(idTxtApodo.getValue() != null && (idTxtApodo.getValue().trim().length()>0) 
				&& idTxtContra.getValue() != null && (idTxtContra.getValue().trim().length()>0)) {
				// Checo que los valores de mis combobox no sean nulos
				if(idCmbTipoUsuario.getSelectedIndex() != -1 && idCmbTiendaAsignada.getSelectedIndex() != -1) {
					// Todo OK, puedo comenzar a guardar
					
					System.out.println("Valor En combo TipoUSuario: " +idCmbTipoUsuario.getValue()+", Index: "+idCmbTipoUsuario.getSelectedIndex() +", ID: " +idCmbTipoUsuario.getId());
					System.out.println("Valor En combo Sitio Asignado: " +idCmbTiendaAsignada.getValue()+", Index: "+idCmbTiendaAsignada.getSelectedIndex() +", Item: " +idCmbTiendaAsignada.getSelectedItem().toString());
					
					
				}
				else {
					// Regreso que no estan seleccionados las opciones en los combos.
				}
			}
			else {
				// Regreso Avisando que faltan el Nickname y/o el PAssword...
			}
		}
		else {
			// Regresar avisando que falta el nombre del Usuario
		}		
	}
	
	
	
	
}
