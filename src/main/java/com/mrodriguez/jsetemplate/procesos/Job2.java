package com.mrodriguez.jsetemplate.procesos;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author ubuntu
 */
public class Job2 implements Job {
    
    private static final Logger logger = Logger.getLogger(Job2.class);

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        
        
        
        
        
        logger.info("THIS IS JOB2 IN EXCECUTION");
    }
    
}
