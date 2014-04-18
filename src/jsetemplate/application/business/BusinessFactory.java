
package jsetemplate.application.business;

public class BusinessFactory {
    
    public static UserBusiness getUserBusiness(){
        return new UserBusinessImpl();
    }
    
}
