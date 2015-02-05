package com.mrodriguez.jsetemplate.procesos;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author mrodriguez
 */
public class Job1 implements Job {
    
    private static final Logger logger = Logger.getLogger(Job1.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        
        
        
        
        
        logger.info("THIS IS JOB1 IN EXCECUTION");
    }
    
}
