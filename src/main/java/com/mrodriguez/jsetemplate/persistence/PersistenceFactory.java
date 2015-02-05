package com.mrodriguez.jsetemplate.persistence;

import com.mrodriguez.jsetemplate.persistence.daos.UserDao;
import com.mrodriguez.jsetemplate.persistence.daos.UserRoleDao;
import com.mrodriguez.jsetemplate.persistence.daos.impl.UserDaoImpl;
import com.mrodriguez.jsetemplate.persistence.daos.impl.UserRoleDaoImpl;

/**
 *
 * @author mrodriguez
 */
public class PersistenceFactory {
    
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }   
    
    public static UserRoleDao getUserRoleDao(){
        return new UserRoleDaoImpl();
    } 
    
}
