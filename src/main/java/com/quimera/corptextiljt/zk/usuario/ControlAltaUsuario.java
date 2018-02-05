package com.quimera.corptextiljt.zk.usuario;


import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.quimera.corptextiljt.model.Acceso;
import com.quimera.corptextiljt.model.Rol;
import com.quimera.corptextiljt.model.Tienda;
import com.quimera.corptextiljt.model.Usuario;
import com.quimera.corptextiljt.service.ServiceAcceso;
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
	
	private static ServiceAcceso serviceAcceso = null;	
	static {
		if (serviceAcceso == null)
			try{
				serviceAcceso = (ServiceAcceso)SpringApplicationContext.getBean(Constants.BEAN_SERVICE_ACCESO);
			}catch (Exception ex){
				ex.printStackTrace();
			}
		
	}
	
	public void initializeContext() {
		initializeComponentes();
	}
	
	private void initializeComponentes() {	
		idTxtNombreUsuario = (Textbox) getFellow("idNombreUsuario");
		idTxtApodo = (Textbox) getFellow("idUsuario");
		idTxtContra = (Textbox) getFellow("idPasswordUser");
		idCmbTipoUsuario = (Combobox) getFellow("idTipoUsuario");
		idCmbTiendaAsignada = (Combobox) getFellow("idTiendaAsignada");
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
					Usuario usuario = new Usuario();
					usuario.setNickName(idTxtApodo.getValue().trim());
					usuario.setPassword(idTxtContra.getValue().trim());
					usuario.setNombre(idTxtNombreUsuario.getValue().trim());
					Tienda tienda = new Tienda();
					tienda.setIdtienda(idCmbTiendaAsignada.getSelectedIndex());
					usuario.setTienda(tienda);
					usuario.setEstatus(1);
					Acceso acceso = new Acceso();
					Rol rol = new Rol();
					rol.setIdrol(idCmbTipoUsuario.getSelectedIndex());
					acceso.setRol(rol);
					acceso.setUsuario(usuario);
					serviceAcceso.add(acceso);
				}
				else {
					showErrorMessage("¡No se puede guardar!, Debe seleccionar el Tipo de Usuario y la Tienda Asignada");
					// Regreso que no estan seleccionados las opciones en los combos.
				}
			}
			else {
				showErrorMessage("¡No se puede guardar!, Falta el Apodo ó el password del Usuario");
				// Regreso Avisando que faltan el Nickname y/o el Password...
			}
		}
		else {
			showErrorMessage("¡No se puede guardar!, Falta el Nombre del Usuario");
			// Regresar avisando que falta el nombre del Usuario
		}		
	}
	
	
    private void showErrorMessage(String error) { 
        try { 
            Messagebox.show(error,("Error"), Messagebox.OK, Messagebox.ERROR); 
        } 
        catch (Exception e) { 
        	e.printStackTrace();
        } 
    } 	
	
	
	
	
}
