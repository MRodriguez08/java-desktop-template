package com.mrodriguez.jsetemplate.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.mrodriguez.jsetemplate.persistence.HibernateUtil;
import com.mrodriguez.jsetemplate.persistence.PersistenceFactory;
import com.mrodriguez.jsetemplate.persistence.daos.UserDao;
import com.mrodriguez.jsetemplate.persistence.daos.UserRoleDao;
import com.mrodriguez.jsetemplate.persistence.entities.UserEntity;
import com.mrodriguez.jsetemplate.persistence.entities.UserRoleEntity;


/**
 *
 * @author mrodriguez
 */
public class UserBusinessImpl implements UserBusiness {
	
	private static Logger logger = Logger.getLogger(UserBusinessImpl.class);
    
    private UserDao userDao = null;
    private UserRoleDao roleDao = null;
    
    public UserBusinessImpl(){
        userDao = PersistenceFactory.getUserDao();
        roleDao = PersistenceFactory.getUserRoleDao();
    }
    
    public List<UserEntity> findAll(){
    	HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
    	List<UserEntity> users = null;
    	try {
    		users = userDao.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage() , e);
		} finally{
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}   
    	return users;
    }
    

    public void create(UserEntity d) throws Exception {
        

    }
    

    public void edit(UserEntity d) throws Exception {
        
       
    }
    

    public UserEntity get(String userId) throws Exception {
        
      return null;
    }
    

    public void delete(String userId) throws Exception {
        
      
    }
    
    public List<UserRoleEntity> findAllRoles(){
    	HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
    	List<UserRoleEntity> roles = null;
    	try {
    		roles = roleDao.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage() , e);
		} finally{
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}   
    	return roles;  
    }
    
}
