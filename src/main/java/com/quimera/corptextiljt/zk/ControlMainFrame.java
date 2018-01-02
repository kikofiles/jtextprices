package com.quimera.corptextiljt.zk;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;

public class ControlMainFrame extends Borderlayout{

	private Center idCenterMainFrame;

	public void loadContext (){
		loadComponents();
	}

	private void loadComponents(){
		idCenterMainFrame = (Center)getFellow("idCenterMainFrame");
	}

	@SuppressWarnings("deprecation")
	public void selectItemMenu (int index){
		
		cleanCenter();
		Div container = new Div ();
		container.setAlign("Center");
		switch (index){
		
		case 1:
			//show list prices and products
			
			Include src = new Include("/producto/list_producto.zul");
			container.appendChild(src);
			idCenterMainFrame.appendChild(container);
			break;

		case 2 :
			//function to add new products by stores
			container.appendChild(new Include("/producto/alta_producto.zul"));
			idCenterMainFrame.appendChild(container);
			break;
		}
	}
	
	private void cleanCenter(){
		while (idCenterMainFrame.getChildren().size() >0 )
			idCenterMainFrame.getChildren().remove(0);
	}
}
