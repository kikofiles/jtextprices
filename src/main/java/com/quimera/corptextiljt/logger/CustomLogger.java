package com.quimera.corptextiljt.logger;

import static com.quimera.corptextiljt.util.Constants.LOG_LEVEL;
import org.apache.log4j.Logger;

public class CustomLogger {

	/**
     * Registra el mensaje si el nivel de log es 1 superior.
     * @param obj Clase que lanza la exepcion
     * @param msg Mensaje de la exepcion
     */
    public void info(Object obj, String msg) {
        Logger logger = Logger.getLogger( CustomLogger.class );
        if(LOG_LEVEL >=1)
        {
           logger.info(obj.getClass().getName()+": "+ msg);
        }
    }

    /**
     * Registra el advertencia si el nivel de log es 2 superior.
     * @param obj Clase que lanza la exepcion
     * @param msg Mensaje de la exepcion
     */
    public void warn(Object obj,  String msg) {
        Logger logger = Logger.getLogger( CustomLogger.class );
        if(LOG_LEVEL >=2)
        {
           logger.warn(obj.getClass().getName()+": "+ msg);
        }
    }

    /**
     * Registra el error si el nivel de log es 3 superior.
     * @param obj Clase que lanza la exepcion
     * @param msg Mensaje de la exepcion
     */
    public  void error(Object obj, Exception ex) { 
        Logger logger = Logger.getLogger( CustomLogger.class );
        
        if(LOG_LEVEL >=3)
        {
          logger.error(obj.getClass().getName()+": ",ex);  
        }   
        else if(LOG_LEVEL >=1)
        {
            logger.error(obj.getClass().getName()+": " + ex.getMessage());  
        }
        
    }
    
    /**
     * Registra el debug si el nivel de log es 3 superior.
     * @param obj Clase que lanza la exepcion
     * @param msg Mensaje de la exepcion
     */
    public void debug(Object obj,  String msg) {
        Logger logger = Logger.getLogger( CustomLogger.class );
        if(LOG_LEVEL >=4)
        {
            logger.info(obj.getClass().getName()+": "+ msg);
        }
    }

}
