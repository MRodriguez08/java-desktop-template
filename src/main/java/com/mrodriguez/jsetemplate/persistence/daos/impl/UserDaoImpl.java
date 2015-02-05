package com.mrodriguez.jsetemplate.persistence.daos.impl;

import com.mrodriguez.jsetemplate.persistence.daos.UserDao;
import com.mrodriguez.jsetemplate.persistence.entities.UserEntity;

/**
 *
 * @author mrodriguez
 */
public class UserDaoImpl extends DaoImpl<String , UserEntity> implements UserDao {
    
    public UserDaoImpl(){
        super();
    }
    
}
