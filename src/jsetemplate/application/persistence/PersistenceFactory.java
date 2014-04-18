package jsetemplate.application.persistence;

import jsetemplate.application.persistence.daos.UserDao;
import jsetemplate.application.persistence.daos.UserDaoImpl;
import jsetemplate.application.persistence.daos.UserRoleDao;
import jsetemplate.application.persistence.daos.UserRoleDaoImpl;

/**
 *
 * @author mauricio
 */
public class PersistenceFactory {
    
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }   
    
    public static UserRoleDao getUserRoleDao(){
        return new UserRoleDaoImpl();
    } 
    
}
