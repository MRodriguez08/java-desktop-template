/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsetemplate.application.business.procesos;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author ubuntu
 */
public class Job1 implements Job {
    
    private static final Logger logger = Logger.getLogger(Job1.class);

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        
        
        
        
        
        logger.info("THIS IS JOB1 IN EXCECUTION");
    }
    
}
