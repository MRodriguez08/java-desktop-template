
package com.mrodriguez.jsetemplate.business;

public class BusinessFactory {
    
    public static UserBusiness getUserBusiness(){
        return new UserBusinessImpl();
    }
    
}
