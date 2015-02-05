package com.mrodriguez.jsetemplate.business;

import java.util.List;

import com.mrodriguez.jsetemplate.persistence.entities.UserEntity;
import com.mrodriguez.jsetemplate.persistence.entities.UserRoleEntity;

/**
 *
 * @author mrodriguez
 */
public interface UserBusiness {
    
    public List<UserEntity> findAll();
    
    public void create(UserEntity d) throws Exception;
    
    public void edit(UserEntity d) throws Exception;
    
    public UserEntity get(String userId) throws Exception;
    
    public void delete(String userId) throws Exception;
    
    public List<UserRoleEntity> findAllRoles();
    
}
