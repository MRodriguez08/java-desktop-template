package jsetemplate.configuration;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Configuration {

    private static final Logger logger = Logger.getLogger(Configuration.class);
	
    Properties properties = null;
 
    /** Nombre del archivo de parametros */
    public final static String CONFIG_FILE_NAME = "configuration.properties";
     
    public final static String EXECUTE_JOB1             = "jsetemplate.jobs.job1.enabled";
    public final static String EXECUTE_JOB2             = "jsetemplate.jobs.job2.enabled";
    public final static String EXECUTE_USER_INTERFACE   = "jsetemplate.userinterface.enabled";

    
 
    private Configuration() {
        this.properties = new Properties();
        try {
            properties.load(Configuration.class.getResourceAsStream(CONFIG_FILE_NAME));
        } catch (IOException ex) {
            logger.error(ex.getMessage() , ex);
        }
    }
 
    /**
     * Implementando Singleton
     *
     * @return
     */
    public static Configuration getInstance() {
        return ConfigurationHolder.INSTANCE;
    }
 
    private static class ConfigurationHolder { 
        private static final Configuration INSTANCE = new Configuration();
    }
 
    /**
     * Retorna la propiedad de configuración solicitada
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
    	String prop = this.properties.getProperty(key);
        return prop;
    }
}