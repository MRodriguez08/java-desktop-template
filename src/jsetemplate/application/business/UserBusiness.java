package jsetemplate.application.business;

import jsetemplate.application.business.util.datatypes.UserDataType;
import java.util.List;
import jsetemplate.application.business.util.datatypes.UserRoleDataType;

/**
 *
 * @author mauricio
 */
public interface UserBusiness {
    
    public List<UserDataType> findAllUsers();
    
    public void newUser(UserDataType d) throws Exception;
    
    public void editUser(UserDataType d) throws Exception;
    
    public UserDataType getUserInfo(String userId) throws Exception;
    
    public void deleteUser(String userId) throws Exception;
    
    public List<UserRoleDataType> findAllRoles();
    
}
