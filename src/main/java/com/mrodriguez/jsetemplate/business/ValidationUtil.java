package com.mrodriguez.jsetemplate.business;

/**
 *
 * @author mauricio
 */
public class ValidationUtil {
    
    public static Boolean isNullOrEmpty(String in){
        return (in == null || in.length() == 0);
    }
    
    public static Boolean isInteger(String in){
        try {
            Integer.valueOf(in);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
