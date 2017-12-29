package com.quimera.corptextiljt.zk.producto;

import java.util.List;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.service.ServiceProducto;
import com.quimera.corptextiljt.service.context.SpringApplicationContext;
import com.quimera.corptextiljt.util.Constants;

public class ControlListProducto extends Window{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ServiceProducto serviceProducto = null;
	
	private Listbox idListProduct;
	
	static {
		if (serviceProducto == null)
			try{
		serviceProducto = (ServiceProducto)SpringApplicationContext.getBean(Constants.BEAN_SERVICE_PRODUCT);
			}catch (Exception ex){
				ex.printStackTrace();
			}
		
	}
	
	public void initContext(){
		loadComponents();
		loadItems();
	}

	private void loadComponents(){
		idListProduct = (Listbox)getFellow("idListProduct");
	}

	private void loadItems (){
		List<Producto> list = serviceProducto.getListProducto(new Producto());
		for (Producto producto : list)
		loadProduct (producto);	
		idListProduct.setMold("paging");
		idListProduct.setPageSize(Constants.SHOW_ROWS_LIST);
	}

	private void loadProduct (Producto producto){
		Listitem item = new Listitem ();
		Listcell cellTela = new Listcell (producto.getNombreProducto());
		item.appendChild(cellTela);
		List<Precioproducto> list = serviceProducto.getLastPrecioProductoByTipo(new Precioproducto(), producto.getIdproducto());
		if (list != null && !list.isEmpty()){
			boolean isSetTienda = false;
			for (Precioproducto precioProducto : list){
				if (!isSetTienda){
					//item.appendChild(new Listcell(precioProducto.getTienda().getNombreTienda()));
					//item.appendChild(new Listcell(""));
					isSetTienda = true;
				}
				switch (precioProducto.getTipoprecio().getIdtipoPrecio()){
				case 1 :
					item.appendChild(new Listcell (formatoDinero(String.valueOf(precioProducto.getPrecioProducto()))));
					break;
				case 2 :
					item.appendChild(new Listcell (formatoDinero(String.valueOf(precioProducto.getPrecioProducto()))));
					break;
				case 3 :
					item.appendChild(new Listcell (formatoDinero(String.valueOf(precioProducto.getPrecioProducto()))));
					break;
				}
			}
		}
		idListProduct.appendChild(item);
	}
	
	private String formatoDinero (String elPrecio ) {
		return elPrecio = "$ "+elPrecio.trim()+"0";
	}
}
