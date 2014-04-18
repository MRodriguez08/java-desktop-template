package jsetemplate.application.business.util.datatypes;

import jsetemplate.application.persistence.entities.UserEntity;
import jsetemplate.application.persistence.entities.UserRoleEntity;

/**
 *
 * @author mauricio
 */
public class DataTypesFactory {
    
    public static UserDataType getUserDataType(UserEntity e){
        UserDataType d = new UserDataType();
        
        d.setEmail(e.getEmail());
        d.setName(e.getName());
        d.setPassword(e.getPassword());
        d.setRole(getUserRoleDataType(e.getRole()));
        d.setSurname(e.getSurname());
        d.setUserId(e.getUserId());
        
        return d;
    }
    
    public static UserRoleDataType getUserRoleDataType(UserRoleEntity e){
        UserRoleDataType d = new UserRoleDataType();
        
        d.setId(e.getId());
        d.setName(e.getName());
        
        return d;
    }
    
}
