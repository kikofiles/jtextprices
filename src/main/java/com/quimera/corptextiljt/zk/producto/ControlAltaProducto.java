package com.quimera.corptextiljt.zk.producto;

import java.util.List;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Button;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.service.ServiceProducto;
import com.quimera.corptextiljt.service.ServicePrecioProducto;
import com.quimera.corptextiljt.service.context.SpringApplicationContext;
import com.quimera.corptextiljt.util.Constants;
import java.math.BigDecimal;



public class ControlAltaProducto extends Window{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Textbox idTxtNombreProducto;
	private Decimalbox idDcmAnchoProducto;
	private Decimalbox idDcmRendimientoProducto;
	private Checkbox idChbCheckTodas;
	private Decimalbox idDcmPrecioRolloCentro;
	private Decimalbox idDcmPrecioMayoreoCentro;
	private Decimalbox idDcmPrecioMenudeoCentro;
	private Decimalbox idDcmPrecioRolloChico;
	private Decimalbox idDcmPrecioMayoreoChico;
	private Decimalbox idDcmPrecioMenudeoChico;
	private Decimalbox idDcmPrecioRolloCruces;
	private Decimalbox idDcmPrecioMayoreoCruces;
	private Decimalbox idDcmPrecioMenudeoCruces;
	private Decimalbox idDcmPrecioRolloMoro;
	private Decimalbox idDcmPrecioMayoreoMoro;
	private Decimalbox idDcmPrecioMenudeoMoro;
	private Decimalbox idDcmPrecioRolloZapo;
	private Decimalbox idDcmPrecioMayoreoZapo;
	private Decimalbox idDcmPrecioMenudeoZapo;
	private Button idBtnCancelar;
	private Button idBtnGuardar;
	
	
	public void initializeContext() {
		initializeComponentes();
		
	}
	
	private void initializeComponentes() {	
		idTxtNombreProducto = (Textbox) getFellow("idNombreProducto");
		idDcmAnchoProducto = (Decimalbox) getFellow("idAnchoProducto");
		idDcmRendimientoProducto = (Decimalbox) getFellow("idRendimientoProducto");
		idChbCheckTodas = (Checkbox) getFellow("idCheckTodas");
		idDcmPrecioRolloCentro = (Decimalbox) getFellow("idPrecioRolloCentro");
		idDcmPrecioMayoreoCentro = (Decimalbox) getFellow("idPrecioMayoreoCentro");
		idDcmPrecioMenudeoCentro = (Decimalbox) getFellow("idPrecioMenudeoCentro");
		idDcmPrecioRolloChico = (Decimalbox) getFellow("idPrecioRolloChico");
		idDcmPrecioMayoreoChico = (Decimalbox) getFellow("idPrecioMayoreoChico");
		idDcmPrecioMenudeoChico = (Decimalbox) getFellow("idPrecioMenudeoChico");
		idDcmPrecioRolloCruces = (Decimalbox) getFellow("idPrecioRolloCruces");
		idDcmPrecioMayoreoCruces = (Decimalbox) getFellow("idPrecioMayoreoCruces");
		idDcmPrecioMenudeoCruces = (Decimalbox) getFellow("idPrecioMenudeoCruces");
		idDcmPrecioRolloMoro = (Decimalbox) getFellow("idPrecioRolloMoro");
		idDcmPrecioMayoreoMoro = (Decimalbox) getFellow("idPrecioMayoreoMoro");
		idDcmPrecioMenudeoMoro = (Decimalbox) getFellow("idPrecioMenudeoMoro");
		idDcmPrecioRolloZapo = (Decimalbox) getFellow("idPrecioRolloZapo");
		idDcmPrecioMayoreoZapo = (Decimalbox) getFellow("idPrecioMayoreoZapo");
		idDcmPrecioMenudeoZapo = (Decimalbox) getFellow("idPrecioMenudeoZapo");
		idBtnCancelar = (Button) getFellow("idBotonCancelar");
		idBtnGuardar = (Button) getFellow("idBotonCancelar");
	}
	
	// Copia el Precio del Centro si será el mismo para todas las tiendas....
	public void checaTipoPrecio(int i) {
		switch (i){
		case 1 :
			if (idDcmPrecioRolloCentro.getValue().compareTo(new BigDecimal("0.00"))>0) {
				if (idChbCheckTodas.isChecked()) {
					idDcmPrecioRolloChico.setValue(idDcmPrecioRolloCentro.getValue());
					idDcmPrecioRolloCruces.setValue(idDcmPrecioRolloCentro.getValue());
					idDcmPrecioRolloMoro.setValue(idDcmPrecioRolloCentro.getValue());
					idDcmPrecioRolloZapo.setValue(idDcmPrecioRolloCentro.getValue());
				}
			}
			break;
		case 2 :
			if (idDcmPrecioMayoreoCentro.getValue().compareTo(new BigDecimal("0.00"))>0) {
				if (idChbCheckTodas.isChecked()) {
					idDcmPrecioMayoreoChico.setValue(idDcmPrecioMayoreoCentro.getValue());
					idDcmPrecioMayoreoCruces.setValue(idDcmPrecioMayoreoCentro.getValue());
					idDcmPrecioMayoreoMoro.setValue(idDcmPrecioMayoreoCentro.getValue());
					idDcmPrecioMayoreoZapo.setValue(idDcmPrecioMayoreoCentro.getValue());
				}
			}
			break;
		case 3 :
			if (idDcmPrecioMenudeoCentro.getValue().compareTo(new BigDecimal("0.00"))>0) {
				if (idChbCheckTodas.isChecked()) {
					idDcmPrecioMenudeoChico.setValue(idDcmPrecioMenudeoCentro.getValue());
					idDcmPrecioMenudeoCruces.setValue(idDcmPrecioMenudeoCentro.getValue());
					idDcmPrecioMenudeoMoro.setValue(idDcmPrecioMenudeoCentro.getValue());
					idDcmPrecioMenudeoZapo.setValue(idDcmPrecioMenudeoCentro.getValue());
				}
			}
			break;
		}
	}
	
	// Se encarga de habilitar o deshabilitar la entrada de precios de acuerdo al tipo de asignacion de precio
	public void habilitaDeshabilita() {
		if(idChbCheckTodas.isChecked()){
			if(idDcmPrecioRolloCentro.getValue()!= null) {
				if (idDcmPrecioRolloCentro.getValue().compareTo(new BigDecimal("0.00"))>0) {
					idDcmPrecioRolloChico.setValue(idDcmPrecioRolloCentro.getValue());					
					idDcmPrecioRolloCruces.setValue(idDcmPrecioRolloCentro.getValue());
					idDcmPrecioRolloMoro.setValue(idDcmPrecioRolloCentro.getValue());
					idDcmPrecioRolloZapo.setValue(idDcmPrecioRolloCentro.getValue());
				}
			}
			else {
				idDcmPrecioRolloChico.setValue(new BigDecimal("0.00"));
				idDcmPrecioRolloCruces.setValue(new BigDecimal("0.00"));
				idDcmPrecioRolloMoro.setValue(new BigDecimal("0.00"));
				idDcmPrecioRolloZapo.setValue(new BigDecimal("0.00"));
			}			
			idDcmPrecioRolloChico.setDisabled(true);
			idDcmPrecioRolloCruces.setDisabled(true);
			idDcmPrecioRolloMoro.setDisabled(true);
			idDcmPrecioRolloZapo.setDisabled(true);
			if(idDcmPrecioMayoreoCentro.getValue()!= null) {
				if (idDcmPrecioMayoreoCentro.getValue().compareTo(new BigDecimal("0.00"))>0) {
					idDcmPrecioMayoreoChico.setValue(idDcmPrecioMayoreoCentro.getValue());					
					idDcmPrecioMayoreoCruces.setValue(idDcmPrecioMayoreoCentro.getValue());
					idDcmPrecioMayoreoMoro.setValue(idDcmPrecioMayoreoCentro.getValue());
					idDcmPrecioMayoreoZapo.setValue(idDcmPrecioMayoreoCentro.getValue());
				}
			}
			else {
				idDcmPrecioMayoreoChico.setValue(new BigDecimal("0.00"));
				idDcmPrecioMayoreoCruces.setValue(new BigDecimal("0.00"));
				idDcmPrecioMayoreoMoro.setValue(new BigDecimal("0.00"));
				idDcmPrecioMayoreoZapo.setValue(new BigDecimal("0.00"));
			}			
			idDcmPrecioMayoreoChico.setDisabled(true);
			idDcmPrecioMayoreoCruces.setDisabled(true);
			idDcmPrecioMayoreoMoro.setDisabled(true);
			idDcmPrecioMayoreoZapo.setDisabled(true);
			if(idDcmPrecioMenudeoCentro.getValue()!= null) {
				if (idDcmPrecioMenudeoCentro.getValue().compareTo(new BigDecimal("0.00"))>0) {
					idDcmPrecioMenudeoChico.setValue(idDcmPrecioMenudeoCentro.getValue());					
					idDcmPrecioMenudeoCruces.setValue(idDcmPrecioMenudeoCentro.getValue());
					idDcmPrecioMenudeoMoro.setValue(idDcmPrecioMenudeoCentro.getValue());
					idDcmPrecioMenudeoZapo.setValue(idDcmPrecioMenudeoCentro.getValue());
				}
			}
			else {
				idDcmPrecioMenudeoChico.setValue(new BigDecimal("0.00"));
				idDcmPrecioMenudeoCruces.setValue(new BigDecimal("0.00"));
				idDcmPrecioMenudeoMoro.setValue(new BigDecimal("0.00"));
				idDcmPrecioMenudeoZapo.setValue(new BigDecimal("0.00"));
			}			
			idDcmPrecioMenudeoChico.setDisabled(true);
			idDcmPrecioMenudeoCruces.setDisabled(true);
			idDcmPrecioMenudeoMoro.setDisabled(true);
			idDcmPrecioMenudeoZapo.setDisabled(true);
		}
		else {
			idDcmPrecioRolloChico.setDisabled(false);
			idDcmPrecioMayoreoChico.setDisabled(false);			
			idDcmPrecioMenudeoChico.setDisabled(false);			
			idDcmPrecioRolloCruces.setDisabled(false);
			idDcmPrecioMayoreoCruces.setDisabled(false);
			idDcmPrecioMenudeoCruces.setDisabled(false);
			idDcmPrecioRolloMoro.setDisabled(false);
			idDcmPrecioMayoreoMoro.setDisabled(false);
			idDcmPrecioMenudeoMoro.setDisabled(false);
			idDcmPrecioRolloZapo.setDisabled(false);
			idDcmPrecioMayoreoZapo.setDisabled(false);
			idDcmPrecioMenudeoZapo.setDisabled(false);			
			idDcmPrecioRolloChico.setValue(new BigDecimal("0.00"));
			idDcmPrecioRolloCruces.setValue(new BigDecimal("0.00"));
			idDcmPrecioRolloMoro.setValue(new BigDecimal("0.00"));
			idDcmPrecioRolloZapo.setValue(new BigDecimal("0.00"));
			idDcmPrecioMayoreoChico.setValue(new BigDecimal("0.00"));
			idDcmPrecioMayoreoCruces.setValue(new BigDecimal("0.00"));
			idDcmPrecioMayoreoMoro.setValue(new BigDecimal("0.00"));
			idDcmPrecioMayoreoZapo.setValue(new BigDecimal("0.00"));
			idDcmPrecioMenudeoChico.setValue(new BigDecimal("0.00"));
			idDcmPrecioMenudeoCruces.setValue(new BigDecimal("0.00"));
			idDcmPrecioMenudeoMoro.setValue(new BigDecimal("0.00"));
			idDcmPrecioMenudeoZapo.setValue(new BigDecimal("0.00"));
		}
	}
	
	// Proceso de almacenamiento de producto
	public void guardaProducto() {
		// Primero checo que hayan puesto el nombre del nuevo producto
		if(idTxtNombreProducto.getValue().trim() != null && idTxtNombreProducto.getValue().trim().length()>0) {
			// Segundo checo los valores de Ancho y de Rendimiento
			if(idDcmAnchoProducto.getValue() != null && (idDcmAnchoProducto.getValue().compareTo(new BigDecimal("0.00"))>0) 
					&& idDcmRendimientoProducto.getValue() != null && (idDcmRendimientoProducto.getValue().compareTo(new BigDecimal("0.00"))>0)) {
				// Tercero comenzare a guardar precios, el unico que SIEMPRE debe aparecer es el del Centro, as[i que primero checo ese:
				if(idDcmPrecioRolloCentro.getValue() != null && (idDcmPrecioRolloCentro.getValue().compareTo(new BigDecimal("0.00"))>0) 
					&& idDcmPrecioMayoreoCentro.getValue() != null && (idDcmPrecioMayoreoCentro.getValue().compareTo(new BigDecimal("0.00"))>0)
					&& idDcmPrecioMenudeoCentro.getValue() != null && (idDcmPrecioMenudeoCentro.getValue().compareTo(new BigDecimal("0.00"))>0)) {
					// Checo si es precio similar para todas las sucursales..., de ser asi solo con los precios del Centro la armo....
						if(idChbCheckTodas.isChecked()) {
							// PUEDO GUARDAR CON LOS PRECIOS SIMILARES PARA TODAS LAS SUCURSALES
						}
						else { // Debo checar que todos los demas precios no sean nulos....
							if(idDcmPrecioRolloChico.getValue() != null && (idDcmPrecioRolloChico.getValue().compareTo(new BigDecimal("0.00"))>0) 
								&& idDcmPrecioMayoreoChico.getValue() != null && (idDcmPrecioMayoreoChico.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioMenudeoChico.getValue() != null && (idDcmPrecioMenudeoChico.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioRolloCruces.getValue() != null && (idDcmPrecioRolloCruces.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioMayoreoCruces.getValue() != null && (idDcmPrecioMayoreoCruces.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioMenudeoCruces.getValue() != null && (idDcmPrecioMenudeoCruces.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioRolloMoro.getValue() != null && (idDcmPrecioRolloMoro.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioMayoreoMoro.getValue() != null && (idDcmPrecioMayoreoMoro.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioMenudeoMoro.getValue() != null && (idDcmPrecioMenudeoMoro.getValue().compareTo(new BigDecimal("0.00"))>0)								
								&& idDcmPrecioRolloZapo.getValue() != null && (idDcmPrecioRolloZapo.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioMayoreoZapo.getValue() != null && (idDcmPrecioMayoreoZapo.getValue().compareTo(new BigDecimal("0.00"))>0)
								&& idDcmPrecioMenudeoZapo.getValue() != null && (idDcmPrecioMenudeoZapo.getValue().compareTo(new BigDecimal("0.00"))>0)) {
								// PUEDO GUARDAR CON LOS PRECIOS DISTInTOS POR SUCURSALES								
							}
							else {
								// Alguno de los precios de las sucursales falta o esta mal formado
							}
						}
				}
				else {
					// Regreso avisando que faltan los valores de precios para el Centro que es obligatorio
				}
			}
			else {
				// Regreso Avisando que faltan el dato de Rendimiento o de Ancho....
			}

		}
		else {
			// Regresar avisando que falta el nombre del Producto
		}		
	}
}
