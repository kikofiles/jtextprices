package com.quimera.corptextiljt.zk;

import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class ControlLogin extends Window{
	
	private Textbox idTxtName;
	private Textbox idTxtPassword;
	
	
	public void initializeContext() {
		initializeComponentes();
		
	}
	
	private void initializeComponentes() {
		idTxtName = (Textbox) getFellow("idTxtName");
		idTxtPassword = (Textbox) getFellow("idTxtPassword");
	}
	
	public void validaPassword() {
		idTxtName.getValue();
		if(idTxtName.getValue() != null && !idTxtName.getValue().trim().equals("") && idTxtPassword.getValue() != null && !idTxtPassword.getValue().trim().equals("")) {
			System.out.println("Usuario llego: "+idTxtName.getValue() +" Password llego: "+idTxtPassword.getValue());
		}
		else {
			System.out.println("AQUI FALTA USUARIO Y/O PASSWORD");
		}		
		
		
	}

}
