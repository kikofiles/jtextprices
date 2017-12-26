package com.quimera.corptextiljt.util;

public class Constants {

	public static PropertyHelper propertyHelper = new PropertyHelper();
    private static Bundle conf = Bundle.conf;
    
    
	public final static int LOG_LEVEL = Integer.parseInt( propertyHelper.getKey( "log.level", conf ).trim());
}
