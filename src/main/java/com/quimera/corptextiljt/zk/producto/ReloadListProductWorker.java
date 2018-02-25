package com.quimera.corptextiljt.zk.producto;

import java.util.List;

import org.zkoss.lang.Threads;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.quimera.corptextiljt.model.Precioproducto;
import com.quimera.corptextiljt.model.Producto;
import com.quimera.corptextiljt.service.ServiceProducto;
import com.quimera.corptextiljt.service.context.SpringApplicationContext;
import com.quimera.corptextiljt.util.Constants;

public class ReloadListProductWorker  extends Thread{

	private Desktop _desktop;
	private Listbox idListProduct;
	private static ServiceProducto serviceProducto = null;

	static {
		if (serviceProducto == null)
			try{
		serviceProducto = (ServiceProducto)SpringApplicationContext.getBean(Constants.BEAN_SERVICE_PRODUCT);
			}catch (Exception ex){
				ex.printStackTrace();
			}
		
	}
	
	public static final void asyncReloadListBox (Desktop desktop, Listbox idListProduct) throws InterruptedException {
		final ReloadListProductWorker worker = new ReloadListProductWorker(desktop, idListProduct);
		synchronized (worker.idListProduct){
			worker.start();
			//Executions.wait(worker.idListProduct);
		}
	}

	public ReloadListProductWorker (Desktop desktop, Listbox idListProduct){
		_desktop =  desktop;
		this.idListProduct = idListProduct;
	}

	public void run (){
		
		if (!_desktop.isServerPushEnabled())
			_desktop.enableServerPush(true);
		int count =1;
		try{
			while (true){
				Executions.activate(_desktop);
				try{
					System.out.println("Init ..."+count);
					loadItems();
					count++;
				}finally {
					Executions.deactivate(_desktop);
				}
				Threads.sleep(100);
			}
			
		}catch (InterruptedException InEx){
			
		}finally {
			if (_desktop.isServerPushEnabled())
				_desktop.enableServerPush(false);
		}
		
	}

	private void loadItems (){
		while (idListProduct.getItems().size() > 0)
			idListProduct.getItems().remove(0);
		List<Producto> list = serviceProducto.getListProducto(new Producto());
		for (Producto producto : list)
		loadProduct (producto);	
		//idListProduct.setMold("paging");
		//idListProduct.setPageSize(Constants.SHOW_ROWS_LIST);
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
