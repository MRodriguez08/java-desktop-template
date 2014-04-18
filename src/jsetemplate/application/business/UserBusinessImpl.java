package jsetemplate.application.business;

import java.util.ArrayList;
import java.util.List;
import jsetemplate.application.business.util.datatypes.DataTypesFactory;
import jsetemplate.application.business.util.datatypes.UserDataType;
import jsetemplate.application.business.util.datatypes.UserRoleDataType;
import jsetemplate.application.persistence.PersistenceFactory;
import jsetemplate.application.persistence.daos.UserDao;
import jsetemplate.application.persistence.daos.UserRoleDao;
import jsetemplate.application.persistence.entities.UserEntity;
import jsetemplate.application.persistence.entities.UserRoleEntity;

/**
 *
 * @author mauricio
 */
public class UserBusinessImpl implements UserBusiness {
    
    private UserDao userDao = null;
    private UserRoleDao roleDao = null;
    
    public UserBusinessImpl(){
        userDao = PersistenceFactory.getUserDao();
        roleDao = PersistenceFactory.getUserRoleDao();
    }
    
    /**
     * Parametros: - 
     * Descripcion: Obtiene todos los usuarios del sistema.
     * @return
     */
    @Override
    public List<UserDataType> findAllUsers(){
        List<UserDataType> userDtList = new ArrayList<UserDataType>();
        List<UserEntity> listEntities = userDao.findAll();
        for (UserEntity userEntity : listEntities) {
            userDtList.add(DataTypesFactory.getUserDataType(userEntity));
        }
        
        return userDtList;
    }
    
    @Override
    public void newUser(UserDataType d) throws Exception {
        

    }
    
    @Override
    public void editUser(UserDataType d) throws Exception {
        
       
    }
    
    @Override
    public UserDataType getUserInfo(String userId) throws Exception {
        
      return null;
    }
    
    @Override
    public void deleteUser(String userId) throws Exception {
        
      
    }
    
    @Override
    public List<UserRoleDataType> findAllRoles(){
        List<UserRoleDataType> roles = new ArrayList<UserRoleDataType>();
        List<UserRoleEntity> listEntities = roleDao.findAll();
        for (UserRoleEntity entity : listEntities) {
            roles.add(DataTypesFactory.getUserRoleDataType(entity));
        }
        
        return roles;    
    }
    
}
