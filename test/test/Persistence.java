package test;

import java.util.List;
import jsetemplate.application.business.BusinessFactory;
import jsetemplate.application.business.UserBusiness;
import jsetemplate.application.business.util.datatypes.UserDataType;
import jsetemplate.application.business.util.datatypes.UserRoleDataType;
import jsetemplate.application.persistence.PersistenceFactory;
import jsetemplate.application.persistence.daos.UserDao;
import jsetemplate.application.persistence.daos.UserRoleDao;
import jsetemplate.application.persistence.entities.UserEntity;
import jsetemplate.application.persistence.entities.UserRoleEntity;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.util.RandomString;

/**
 *
 * @author ubuntu
 */
public class Persistence {

    private UserRoleDao roleDao = null;
    private UserDao userDao = null;
    
    public Persistence() {
        roleDao = PersistenceFactory.getUserRoleDao();
        userDao = PersistenceFactory.getUserDao();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void findAllUsers() {
        
        //find all in database
        UserDao userDao = PersistenceFactory.getUserDao();
        List<UserEntity> entities = userDao.findAll();
        
        //find all in business
        UserBusiness userBusiness = BusinessFactory.getUserBusiness();
        List<UserDataType> users = userBusiness.findAllUsers();      
        
        assertEquals(users.size(),entities.size());
    }
    
    @Test
    public void findAllUserRoles() {
        
        //find all in database
        UserRoleDao userRoleDao = PersistenceFactory.getUserRoleDao();
        List<UserRoleEntity> entities = userRoleDao.findAll();
        
        //find all in business
        UserBusiness userBusiness = BusinessFactory.getUserBusiness();
        List<UserRoleDataType> roles = userBusiness.findAllRoles();      
        
        assertEquals(roles.size(),entities.size());
    }
    
    @Test
    public void createUser(){
    
        String userId = newUserEntity();
        
        UserEntity userCheck = userDao.findById(userId);
        
        assertTrue( userCheck != null);
    }
    
    @Test
    public void updateUser(){
    
        String userId = newUserEntity();
        
        UserEntity user = userDao.findById(userId);
        
        assertTrue( user != null);
        
        user.setEmail("newemail@gmail.com");
        user.setName("newname");
        user.setPassword("newpassword");
        user.setSurname("newsurname");
        UserRoleEntity role = roleDao.findById(3);
        user.setRole(role);
        
        userDao.merge(user);
        userDao.flush();
        
        UserEntity userCheck = userDao.findById(userId);
        assertTrue( userCheck != null);
        assertEquals("newemail@gmail.com", userCheck.getEmail());
        assertEquals("newname",userCheck.getName());
        assertEquals("newpassword",userCheck.getPassword());
        assertEquals("newsurname",userCheck.getSurname());
        assertEquals(String.valueOf(3),String.valueOf(userCheck.getRole().getId()));      
    }
    
    private String newUserEntity(){       
        
        UserEntity user = new UserEntity();
        UserRoleEntity role = roleDao.findById(1);        
        
        String userId = "peter" + (new RandomString(15)).generateRandomString();
        
        user.setEmail("jhon@gmail.com");
        user.setName("jhon");
        user.setPassword("XXXXX");
        user.setSurname("doe");
        user.setUserId(userId);
        user.setRole(role);
        
        userDao.persist(user);
        userDao.flush();        
        
        return userId;
    }

}
