package com.quimera.corptextiljt.util;

import com.quimera.corptextiljt.util.PropertyHelper.Bundle;

public class Constants {

	public static PropertyHelper propertyHelper = new PropertyHelper();
    private static Bundle conf = Bundle.conf;
    
    
	public final static int LOG_LEVEL = Integer.parseInt( propertyHelper.getKey( "log.level", conf ).trim());
	public final static String LocaleSpanish = "MX";
	public final static String LocaleEnglish = "US";
	public final static String LOCALE_LANGUAGE = "locale";
	
	public final static int SHOW_ROWS_LIST = Integer.parseInt( propertyHelper.getKey( "show.rows.list", conf ).trim());	
	
	/////////// beans Spring 
	
	public static final String BEAN_SERVICE_PRODUCT = "serviceProducto";
	public static final String BEAN_SERVICE_ACCESO = "serviceAcceso";
}
