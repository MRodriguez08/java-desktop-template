package jsetemplate;

import jsetemplate.application.business.procesos.JobManager;
import jsetemplate.application.presentation.otros.InitError;
import jsetemplate.application.presentation.users.MainUsers;
import jsetemplate.configuration.Configuration;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

/**
 *
 * @author mauricio
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    
    public static void main(String[] args) {        
        
        try {
            
            logger.info("INICIANDO APLICACIÓN DE ALERTA DE VENCIMIENTOS");
            
            //Lanzo los procesos automáticos del sistema
            JobManager.startJobs();
            
            //Lanzo la pantalla principal del sistema            
            if (Boolean.valueOf(Configuration.getInstance().getProperty(Configuration.EXECUTE_USER_INTERFACE))){
                MainUsers mw = new MainUsers();
                mw.setVisible(true);        
            }            
            
        } catch (SchedulerException e) {
            InitError ei = new InitError();
            ei.setVisible(true);
        }        
        
    }
    
}
