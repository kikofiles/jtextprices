package com.quimera.corptextiljt.zk.producto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.model.Tienda;
import com.quimera.corptextiljt.model.Tipoprecio;
import com.quimera.corptextiljt.model.Usuario;
import com.quimera.corptextiljt.service.ServiceProducto;
import com.quimera.corptextiljt.service.context.SpringApplicationContext;
import com.quimera.corptextiljt.util.Constants;



public class ControlAltaProducto extends Window{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
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
	private Window idWindowAltaProducto;
	
	private static ServiceProducto serviceProducto = null;	
	static {
		if (serviceProducto == null)
			try{
		serviceProducto = (ServiceProducto)SpringApplicationContext.getBean(Constants.BEAN_SERVICE_PRODUCT);
			}catch (Exception ex){
				ex.printStackTrace();
			}
		
	}
	
	
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
		idWindowAltaProducto = (Window)getFellow("idWindowAltaProducto");
		date = new Date();
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
							Producto producto = new Producto();
							producto.setAncho(idDcmAnchoProducto.doubleValue());
							producto.setRendimiento(idDcmRendimientoProducto.doubleValue());
							producto.setNombreProducto(idTxtNombreProducto.getValue());
							producto.setEstatus(1);
							Set<Precioproducto> precioproductos = new HashSet<Precioproducto>(0);
							// Una vez terminado el Login quitar el HARDCODE del ID Usuario!!!
							Usuario usuario = new Usuario();
							usuario.setIdusuario(1);								
							
							// Pack Tienda Centro:
							Precioproducto precioProduc1 = new Precioproducto();
							Precioproducto precioProduc1b = new Precioproducto();
							Precioproducto precioProduc1c = new Precioproducto();
							Tienda tiendaCentro = new Tienda();
							tiendaCentro.setIdtienda(1);
							// Alta Rollo
							Tipoprecio tipoprecioCentroRollo= new Tipoprecio();
							tipoprecioCentroRollo.setIdtipoPrecio(1);
							precioProduc1.setTipoprecio(tipoprecioCentroRollo);								
							precioProduc1.setPrecioProducto(idDcmPrecioRolloCentro.doubleValue());
							precioProduc1.setTienda(tiendaCentro);
							precioProduc1.setFechaAlta(date);
							precioProduc1.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc1.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc1.setFechaMod(date);
							precioProduc1.setEstatus(1);
							precioProduc1.setProducto(producto);
							//Alta Mayoreo
							Tipoprecio tipoprecioCentroMayoreo= new Tipoprecio();
							tipoprecioCentroMayoreo.setIdtipoPrecio(2);
							precioProduc1b.setTipoprecio(tipoprecioCentroMayoreo);								
							precioProduc1b.setPrecioProducto(idDcmPrecioMayoreoCentro.doubleValue());
							precioProduc1b.setTienda(tiendaCentro);
							precioProduc1b.setFechaAlta(date);
							precioProduc1b.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc1b.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc1b.setFechaMod(date);
							precioProduc1b.setEstatus(1);
							precioProduc1b.setProducto(producto);
							//Alta Menudeo
							Tipoprecio tipoprecioCentroMenudeo= new Tipoprecio();
							tipoprecioCentroMenudeo.setIdtipoPrecio(3);
							precioProduc1c.setTipoprecio(tipoprecioCentroMenudeo);								
							precioProduc1c.setPrecioProducto(idDcmPrecioMenudeoCentro.doubleValue());
							precioProduc1c.setTienda(tiendaCentro);
							precioProduc1c.setFechaAlta(date);
							precioProduc1c.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc1c.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc1c.setFechaMod(date);
							precioProduc1c.setEstatus(1);
							precioProduc1c.setProducto(producto);
							
							// Pack Tienda Chico:
							Precioproducto precioProduc2 = new Precioproducto();
							Precioproducto precioProduc2b = new Precioproducto();
							Precioproducto precioProduc2c = new Precioproducto();
							Tienda tiendaChico = new Tienda();
							tiendaChico.setIdtienda(2);
							// Alta Rollo
							Tipoprecio tipoprecioChicoRollo= new Tipoprecio();
							tipoprecioChicoRollo.setIdtipoPrecio(1);
							precioProduc2.setTipoprecio(tipoprecioChicoRollo);						
							precioProduc2.setPrecioProducto(idDcmPrecioRolloCentro.doubleValue());
							precioProduc2.setTienda(tiendaChico);
							precioProduc2.setFechaAlta(date);
							precioProduc2.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc2.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc2.setFechaMod(date);
							precioProduc2.setEstatus(1);
							precioProduc2.setProducto(producto);
							//Alta Mayoreo
							Tipoprecio tipoprecioChicoMayoreo= new Tipoprecio();
							tipoprecioChicoMayoreo.setIdtipoPrecio(2);
							precioProduc2b.setTipoprecio(tipoprecioChicoMayoreo);								
							precioProduc2b.setPrecioProducto(idDcmPrecioMayoreoCentro.doubleValue());
							precioProduc2b.setTienda(tiendaChico);
							precioProduc2b.setFechaAlta(date);
							precioProduc2b.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc2b.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc2b.setFechaMod(date);
							precioProduc2b.setEstatus(1);
							precioProduc2b.setProducto(producto);
							//Alta Menudeo
							Tipoprecio tipoprecioChicoMenudeo= new Tipoprecio();
							tipoprecioChicoMenudeo.setIdtipoPrecio(3);
							precioProduc2c.setTipoprecio(tipoprecioChicoMenudeo);								
							precioProduc2c.setPrecioProducto(idDcmPrecioMenudeoCentro.doubleValue());
							precioProduc2c.setTienda(tiendaChico);
							precioProduc2c.setFechaAlta(date);
							precioProduc2c.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc2c.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc2c.setFechaMod(date);
							precioProduc2c.setEstatus(1);
							precioProduc2c.setProducto(producto);
							
							// Pack Tienda Moro:
							Precioproducto precioProduc3 = new Precioproducto();
							Precioproducto precioProduc3b = new Precioproducto();
							Precioproducto precioProduc3c = new Precioproducto();								
							Tienda tiendaMoro = new Tienda();
							tiendaMoro.setIdtienda(3);
							// Alta Rollo
							Tipoprecio tipoprecioMoroRollo= new Tipoprecio();
							tipoprecioMoroRollo.setIdtipoPrecio(1);
							precioProduc3.setTipoprecio(tipoprecioMoroRollo);						
							precioProduc3.setPrecioProducto(idDcmPrecioRolloCentro.doubleValue());
							precioProduc3.setTienda(tiendaMoro);
							precioProduc3.setFechaAlta(date);
							precioProduc3.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc3.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc3.setFechaMod(date);
							precioProduc3.setEstatus(1);
							precioProduc3.setProducto(producto);
							//Alta Mayoreo
							Tipoprecio tipoprecioMoroMayoreo= new Tipoprecio();
							tipoprecioMoroMayoreo.setIdtipoPrecio(2);
							precioProduc3b.setTipoprecio(tipoprecioMoroMayoreo);								
							precioProduc3b.setPrecioProducto(idDcmPrecioMayoreoCentro.doubleValue());
							precioProduc3b.setTienda(tiendaMoro);
							precioProduc3b.setFechaAlta(date);
							precioProduc3b.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc3b.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc3b.setFechaMod(date);
							precioProduc3b.setEstatus(1);
							precioProduc3b.setProducto(producto);
							//Alta Menudeo
							Tipoprecio tipoprecioMoroMenudeo= new Tipoprecio();
							tipoprecioMoroMenudeo.setIdtipoPrecio(3);
							precioProduc3c.setTipoprecio(tipoprecioMoroMenudeo);								
							precioProduc3c.setPrecioProducto(idDcmPrecioMenudeoCentro.doubleValue());
							precioProduc3c.setTienda(tiendaMoro);
							precioProduc3c.setFechaAlta(date);
							precioProduc3c.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc3c.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc3c.setFechaMod(date);
							precioProduc3c.setEstatus(1);
							precioProduc3c.setProducto(producto);
							
							// Pack Tienda Zapo:
							Precioproducto precioProduc4 = new Precioproducto();
							Precioproducto precioProduc4b = new Precioproducto();
							Precioproducto precioProduc4c = new Precioproducto();
							Tienda tiendaZapo = new Tienda();
							tiendaZapo.setIdtienda(4);
							// Alta Rollo
							Tipoprecio tipoprecioZapoRollo= new Tipoprecio();
							tipoprecioZapoRollo.setIdtipoPrecio(1);
							precioProduc4.setTipoprecio(tipoprecioZapoRollo);						
							precioProduc4.setPrecioProducto(idDcmPrecioRolloCentro.doubleValue());
							precioProduc4.setTienda(tiendaZapo);
							precioProduc4.setFechaAlta(date);
							precioProduc4.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc4.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc4.setFechaMod(date);
							precioProduc4.setEstatus(1);
							precioProduc4.setProducto(producto);
							//Alta Mayoreo
							Tipoprecio tipoprecioZapoMayoreo= new Tipoprecio();
							tipoprecioZapoMayoreo.setIdtipoPrecio(2);
							precioProduc4b.setTipoprecio(tipoprecioZapoMayoreo);								
							precioProduc4b.setPrecioProducto(idDcmPrecioMayoreoCentro.doubleValue());
							precioProduc4b.setTienda(tiendaZapo);
							precioProduc4b.setFechaAlta(date);
							precioProduc4b.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc4b.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc4b.setFechaMod(date);
							precioProduc4b.setEstatus(1);
							precioProduc4b.setProducto(producto);
							//Alta Menudeo
							Tipoprecio tipoprecioZapoMenudeo= new Tipoprecio();
							tipoprecioZapoMenudeo.setIdtipoPrecio(3);
							precioProduc4c.setTipoprecio(tipoprecioZapoMenudeo);								
							precioProduc4c.setPrecioProducto(idDcmPrecioMenudeoCentro.doubleValue());
							precioProduc4c.setTienda(tiendaZapo);
							precioProduc4c.setFechaAlta(date);
							precioProduc4c.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc4c.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc4c.setFechaMod(date);
							precioProduc4c.setEstatus(1);
							precioProduc4c.setProducto(producto);

							// Pack Tienda Cruces:
							Precioproducto precioProduc5 = new Precioproducto();
							Precioproducto precioProduc5b = new Precioproducto();
							Precioproducto precioProduc5c = new Precioproducto();
							Tienda tiendaCruces = new Tienda();
							tiendaCruces.setIdtienda(5);
							// Alta Rollo
							Tipoprecio tipoprecioCrucesRollo= new Tipoprecio();
							tipoprecioCrucesRollo.setIdtipoPrecio(1);
							precioProduc5.setTipoprecio(tipoprecioCrucesRollo);						
							precioProduc5.setPrecioProducto(idDcmPrecioRolloCentro.doubleValue());
							precioProduc5.setTienda(tiendaCruces);
							precioProduc5.setFechaAlta(date);
							precioProduc5.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc5.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc5.setFechaMod(date);
							precioProduc5.setEstatus(1);
							precioProduc5.setProducto(producto);
							//Alta Mayoreo
							Tipoprecio tipoprecioCrucesMayoreo= new Tipoprecio();
							tipoprecioCrucesMayoreo.setIdtipoPrecio(2);
							precioProduc5b.setTipoprecio(tipoprecioCrucesMayoreo);								
							precioProduc5b.setPrecioProducto(idDcmPrecioMayoreoCentro.doubleValue());
							precioProduc5b.setTienda(tiendaCruces);
							precioProduc5b.setFechaAlta(date);
							precioProduc5b.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc5b.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc5b.setFechaMod(date);
							precioProduc5b.setEstatus(1);
							precioProduc5b.setProducto(producto);
							//Alta Menudeo
							Tipoprecio tipoprecioCrucesMenudeo= new Tipoprecio();
							tipoprecioCrucesMenudeo.setIdtipoPrecio(3);
							precioProduc5c.setTipoprecio(tipoprecioCrucesMenudeo);								
							precioProduc5c.setPrecioProducto(idDcmPrecioMenudeoCentro.doubleValue());
							precioProduc5c.setTienda(tiendaCruces);
							precioProduc5c.setFechaAlta(date);
							precioProduc5c.setUsuarioByUsuarioIdusuarioAlta(usuario);
							precioProduc5c.setUsuarioByUsuarioIdusuarioModifica(usuario);
							precioProduc5c.setFechaMod(date);
							precioProduc5c.setEstatus(1);
							precioProduc5c.setProducto(producto);
							
							precioproductos.add(precioProduc1);
							precioproductos.add(precioProduc1b);
							precioproductos.add(precioProduc1c);
							precioproductos.add(precioProduc2);
							precioproductos.add(precioProduc2b);
							precioproductos.add(precioProduc2c);
							precioproductos.add(precioProduc3);
							precioproductos.add(precioProduc3b);
							precioproductos.add(precioProduc3c);
							precioproductos.add(precioProduc4);
							precioproductos.add(precioProduc4b);
							precioproductos.add(precioProduc4c);
							precioproductos.add(precioProduc5);
							precioproductos.add(precioProduc5b);
							precioproductos.add(precioProduc5c);
							producto.setPrecioproductos(precioproductos);
							serviceProducto.add(producto);
							
							
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
								
								Producto producto = new Producto();
								producto.setAncho(idDcmAnchoProducto.doubleValue());
								producto.setRendimiento(idDcmRendimientoProducto.doubleValue());
								producto.setNombreProducto(idTxtNombreProducto.getValue());
								producto.setEstatus(1);
								Set<Precioproducto> precioproductos = new HashSet<Precioproducto>(0);
								// Una vez terminado el Login quitar el HARDCODE del ID Usuario!!!
								Usuario usuario = new Usuario();
								usuario.setIdusuario(1);								
								
								// Pack Tienda Centro:
								Precioproducto precioProduc1 = new Precioproducto();
								Precioproducto precioProduc1b = new Precioproducto();
								Precioproducto precioProduc1c = new Precioproducto();
								Tienda tiendaCentro = new Tienda();
								tiendaCentro.setIdtienda(1);
								// Alta Rollo
								Tipoprecio tipoprecioCentroRollo= new Tipoprecio();
								tipoprecioCentroRollo.setIdtipoPrecio(1);
								precioProduc1.setTipoprecio(tipoprecioCentroRollo);								
								precioProduc1.setPrecioProducto(idDcmPrecioRolloCentro.doubleValue());
								precioProduc1.setTienda(tiendaCentro);
								precioProduc1.setFechaAlta(date);
								precioProduc1.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc1.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc1.setFechaMod(date);
								precioProduc1.setEstatus(1);
								precioProduc1.setProducto(producto);
								//Alta Mayoreo
								Tipoprecio tipoprecioCentroMayoreo= new Tipoprecio();
								tipoprecioCentroMayoreo.setIdtipoPrecio(2);
								precioProduc1b.setTipoprecio(tipoprecioCentroMayoreo);								
								precioProduc1b.setPrecioProducto(idDcmPrecioMayoreoCentro.doubleValue());
								precioProduc1b.setTienda(tiendaCentro);
								precioProduc1b.setFechaAlta(date);
								precioProduc1b.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc1b.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc1b.setFechaMod(date);
								precioProduc1b.setEstatus(1);
								precioProduc1b.setProducto(producto);
								//Alta Menudeo
								Tipoprecio tipoprecioCentroMenudeo= new Tipoprecio();
								tipoprecioCentroMenudeo.setIdtipoPrecio(3);
								precioProduc1c.setTipoprecio(tipoprecioCentroMenudeo);								
								precioProduc1c.setPrecioProducto(idDcmPrecioMenudeoCentro.doubleValue());
								precioProduc1c.setTienda(tiendaCentro);
								precioProduc1c.setFechaAlta(date);
								precioProduc1c.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc1c.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc1c.setFechaMod(date);
								precioProduc1c.setEstatus(1);
								precioProduc1c.setProducto(producto);
								
								// Pack Tienda Chico:
								Precioproducto precioProduc2 = new Precioproducto();
								Precioproducto precioProduc2b = new Precioproducto();
								Precioproducto precioProduc2c = new Precioproducto();
								Tienda tiendaChico = new Tienda();
								tiendaChico.setIdtienda(2);
								// Alta Rollo
								Tipoprecio tipoprecioChicoRollo= new Tipoprecio();
								tipoprecioChicoRollo.setIdtipoPrecio(1);
								precioProduc2.setTipoprecio(tipoprecioChicoRollo);						
								precioProduc2.setPrecioProducto(idDcmPrecioRolloChico.doubleValue());
								precioProduc2.setTienda(tiendaChico);
								precioProduc2.setFechaAlta(date);
								precioProduc2.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc2.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc2.setFechaMod(date);
								precioProduc2.setEstatus(1);
								precioProduc2.setProducto(producto);
								//Alta Mayoreo
								Tipoprecio tipoprecioChicoMayoreo= new Tipoprecio();
								tipoprecioChicoMayoreo.setIdtipoPrecio(2);
								precioProduc2b.setTipoprecio(tipoprecioChicoMayoreo);								
								precioProduc2b.setPrecioProducto(idDcmPrecioMayoreoChico.doubleValue());
								precioProduc2b.setTienda(tiendaChico);
								precioProduc2b.setFechaAlta(date);
								precioProduc2b.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc2b.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc2b.setFechaMod(date);
								precioProduc2b.setEstatus(1);
								precioProduc2b.setProducto(producto);
								//Alta Menudeo
								Tipoprecio tipoprecioChicoMenudeo= new Tipoprecio();
								tipoprecioChicoMenudeo.setIdtipoPrecio(3);
								precioProduc2c.setTipoprecio(tipoprecioChicoMenudeo);								
								precioProduc2c.setPrecioProducto(idDcmPrecioMenudeoChico.doubleValue());
								precioProduc2c.setTienda(tiendaChico);
								precioProduc2c.setFechaAlta(date);
								precioProduc2c.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc2c.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc2c.setFechaMod(date);
								precioProduc2c.setEstatus(1);
								precioProduc2c.setProducto(producto);
								
								// Pack Tienda Moro:
								Precioproducto precioProduc3 = new Precioproducto();
								Precioproducto precioProduc3b = new Precioproducto();
								Precioproducto precioProduc3c = new Precioproducto();								
								Tienda tiendaMoro = new Tienda();
								tiendaMoro.setIdtienda(3);
								// Alta Rollo
								Tipoprecio tipoprecioMoroRollo= new Tipoprecio();
								tipoprecioMoroRollo.setIdtipoPrecio(1);
								precioProduc3.setTipoprecio(tipoprecioMoroRollo);						
								precioProduc3.setPrecioProducto(idDcmPrecioRolloMoro.doubleValue());
								precioProduc3.setTienda(tiendaMoro);
								precioProduc3.setFechaAlta(date);
								precioProduc3.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc3.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc3.setFechaMod(date);
								precioProduc3.setEstatus(1);
								precioProduc3.setProducto(producto);
								//Alta Mayoreo
								Tipoprecio tipoprecioMoroMayoreo= new Tipoprecio();
								tipoprecioMoroMayoreo.setIdtipoPrecio(2);
								precioProduc3b.setTipoprecio(tipoprecioMoroMayoreo);								
								precioProduc3b.setPrecioProducto(idDcmPrecioMayoreoMoro.doubleValue());
								precioProduc3b.setTienda(tiendaMoro);
								precioProduc3b.setFechaAlta(date);
								precioProduc3b.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc3b.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc3b.setFechaMod(date);
								precioProduc3b.setEstatus(1);
								precioProduc3b.setProducto(producto);
								//Alta Menudeo
								Tipoprecio tipoprecioMoroMenudeo= new Tipoprecio();
								tipoprecioMoroMenudeo.setIdtipoPrecio(3);
								precioProduc3c.setTipoprecio(tipoprecioMoroMenudeo);								
								precioProduc3c.setPrecioProducto(idDcmPrecioMenudeoMoro.doubleValue());
								precioProduc3c.setTienda(tiendaMoro);
								precioProduc3c.setFechaAlta(date);
								precioProduc3c.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc3c.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc3c.setFechaMod(date);
								precioProduc3c.setEstatus(1);
								precioProduc3c.setProducto(producto);
								
								// Pack Tienda Zapo:
								Precioproducto precioProduc4 = new Precioproducto();
								Precioproducto precioProduc4b = new Precioproducto();
								Precioproducto precioProduc4c = new Precioproducto();
								Tienda tiendaZapo = new Tienda();
								tiendaZapo.setIdtienda(4);
								// Alta Rollo
								Tipoprecio tipoprecioZapoRollo= new Tipoprecio();
								tipoprecioZapoRollo.setIdtipoPrecio(1);
								precioProduc4.setTipoprecio(tipoprecioZapoRollo);						
								precioProduc4.setPrecioProducto(idDcmPrecioRolloZapo.doubleValue());
								precioProduc4.setTienda(tiendaZapo);
								precioProduc4.setFechaAlta(date);
								precioProduc4.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc4.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc4.setFechaMod(date);
								precioProduc4.setEstatus(1);
								precioProduc4.setProducto(producto);
								//Alta Mayoreo
								Tipoprecio tipoprecioZapoMayoreo= new Tipoprecio();
								tipoprecioZapoMayoreo.setIdtipoPrecio(2);
								precioProduc4b.setTipoprecio(tipoprecioZapoMayoreo);								
								precioProduc4b.setPrecioProducto(idDcmPrecioMayoreoZapo.doubleValue());
								precioProduc4b.setTienda(tiendaZapo);
								precioProduc4b.setFechaAlta(date);
								precioProduc4b.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc4b.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc4b.setFechaMod(date);
								precioProduc4b.setEstatus(1);
								precioProduc4b.setProducto(producto);
								//Alta Menudeo
								Tipoprecio tipoprecioZapoMenudeo= new Tipoprecio();
								tipoprecioZapoMenudeo.setIdtipoPrecio(3);
								precioProduc4c.setTipoprecio(tipoprecioZapoMenudeo);								
								precioProduc4c.setPrecioProducto(idDcmPrecioMenudeoZapo.doubleValue());
								precioProduc4c.setTienda(tiendaZapo);
								precioProduc4c.setFechaAlta(date);
								precioProduc4c.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc4c.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc4c.setFechaMod(date);
								precioProduc4c.setEstatus(1);
								precioProduc4c.setProducto(producto);

								// Pack Tienda Cruces:
								Precioproducto precioProduc5 = new Precioproducto();
								Precioproducto precioProduc5b = new Precioproducto();
								Precioproducto precioProduc5c = new Precioproducto();
								Tienda tiendaCruces = new Tienda();
								tiendaCruces.setIdtienda(5);
								// Alta Rollo
								Tipoprecio tipoprecioCrucesRollo= new Tipoprecio();
								tipoprecioCrucesRollo.setIdtipoPrecio(1);
								precioProduc5.setTipoprecio(tipoprecioCrucesRollo);						
								precioProduc5.setPrecioProducto(idDcmPrecioRolloCruces.doubleValue());
								precioProduc5.setTienda(tiendaCruces);
								precioProduc5.setFechaAlta(date);
								precioProduc5.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc5.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc5.setFechaMod(date);
								precioProduc5.setEstatus(1);
								precioProduc5.setProducto(producto);
								//Alta Mayoreo
								Tipoprecio tipoprecioCrucesMayoreo= new Tipoprecio();
								tipoprecioCrucesMayoreo.setIdtipoPrecio(2);
								precioProduc5b.setTipoprecio(tipoprecioCrucesMayoreo);								
								precioProduc5b.setPrecioProducto(idDcmPrecioMayoreoCruces.doubleValue());
								precioProduc5b.setTienda(tiendaCruces);
								precioProduc5b.setFechaAlta(date);
								precioProduc5b.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc5b.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc5b.setFechaMod(date);
								precioProduc5b.setEstatus(1);
								precioProduc5b.setProducto(producto);
								//Alta Menudeo
								Tipoprecio tipoprecioCrucesMenudeo= new Tipoprecio();
								tipoprecioCrucesMenudeo.setIdtipoPrecio(3);
								precioProduc5c.setTipoprecio(tipoprecioCrucesMenudeo);								
								precioProduc5c.setPrecioProducto(idDcmPrecioMenudeoCruces.doubleValue());
								precioProduc5c.setTienda(tiendaCruces);
								precioProduc5c.setFechaAlta(date);
								precioProduc5c.setUsuarioByUsuarioIdusuarioAlta(usuario);
								precioProduc5c.setUsuarioByUsuarioIdusuarioModifica(usuario);
								precioProduc5c.setFechaMod(date);
								precioProduc5c.setEstatus(1);
								precioProduc5c.setProducto(producto);
								
								precioproductos.add(precioProduc1);
								precioproductos.add(precioProduc1b);
								precioproductos.add(precioProduc1c);
								precioproductos.add(precioProduc2);
								precioproductos.add(precioProduc2b);
								precioproductos.add(precioProduc2c);
								precioproductos.add(precioProduc3);
								precioproductos.add(precioProduc3b);
								precioproductos.add(precioProduc3c);
								precioproductos.add(precioProduc4);
								precioproductos.add(precioProduc4b);
								precioproductos.add(precioProduc4c);
								precioproductos.add(precioProduc5);
								precioproductos.add(precioProduc5b);
								precioproductos.add(precioProduc5c);
								producto.setPrecioproductos(precioproductos);
								serviceProducto.add(producto);
//								win.detach();
								//mensaje
								//redirect
								
							}
							else {
								// Alguno de los precios de las sucursales falta o esta mal formado
								showErrorMessage("¡No se puede guardar!, Faltan Precios en Sucursales ó están mal formados");
							}
						}
				}
				else {
					// Regreso avisando que faltan los valores de precios para el Centro que es obligatorio
					showErrorMessage("¡No se puede guardar!, Faltan los valores de Precios para el Centro");
				}
			}
			else {
				// Regreso Avisando que faltan el dato de Rendimiento o de Ancho....
				showErrorMessage("¡No se puede guardar!, Faltan el dato de Ancho ó de Rendimiento");
			}
		}
		else {
			// Regresar avisando que falta el nombre del Producto
			idTxtNombreProducto.focus();
			showErrorMessage("¡No se puede guardar!, Falta el Nombre del Producto");
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
