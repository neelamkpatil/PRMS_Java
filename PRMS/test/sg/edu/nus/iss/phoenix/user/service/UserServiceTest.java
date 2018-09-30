/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.user.entity.Role;
import sg.edu.nus.iss.phoenix.user.entity.User;

/**
 *
 * @author Surbhi Tayal
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }
    
   UserService instance;
  
 
    @Before
    public void setUp() {
        instance = new UserService();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of searchPrograms method, of class UserService.
     */
    @Test
    public void testSearchPrograms() {
        System.out.println("searchPrograms");
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        instance.processCreate(ur);
        ArrayList<User> result = instance.searchPrograms(ur);
        assertEquals(ur.getId(), result.get(0).getId());
        //to delete the created user instance from db
        instance.processDelete(ur.getId()); 
    }

    /**
     * Test of findURByCriteria method, of class UserService.
     * 
     */
    @Test
    public void testFindURByCriteria() {
        System.out.println("findURByCriteria");
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        instance.processCreate(ur);
        ArrayList<User> result = instance.findURByCriteria(ur);
        assertEquals(ur.getId(), result.get(0).getId());
        //to delete the created user instance from db
        instance.processDelete(ur.getId());
      
    
    }

    /**
     * Test of findUR method, of class UserService.
     */
    @Test
    public void testFindUR() {
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        instance.processCreate(ur);
        User result = instance.findUR(ur.getId());
        assertEquals(ur.getId(), result.getId());
        //to delete the created user instance from db
        instance.processDelete(ur.getId());
    }

    /**
     * Test of findAllUR method, of class UserService.
     */
    @Test
    public void testFindAllUR() {
        System.out.println("findAllUR");
        ArrayList<User> result = instance.findAllUR();
        assertNotNull(result);
    }

    /**
     * Test of processCreate method, of class UserService.
     * Note: this test case should run successfully if 'id' of user is not already present.
     * please do check and change 'id' before running test case.
     */
    
    @Test
    public void testProcessCreate() {
        System.out.println("processCreate");
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        instance.processCreate(ur);
        User result = instance.findUR(ur.getId());
        assertEquals(ur.getName(), result.getName());
        //to delete user object from DB
        instance.processDelete(ur.getId());  
    }

    /**
     * Test of processModify method, of class UserService.
     */
    @Test
    public void testProcessModify() {
        System.out.println("processModify");
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        instance.processCreate(ur);
        User ur1 = new User("sur", "test", "New name", roles);
        instance.processModify(ur1);
        User userFromQuery = instance.findUR(ur1.getId());
        assertEquals(userFromQuery.getName(),ur1.getName());
        //to delete created user uinstance from DB
        instance.processDelete(ur.getId());
       
    }

    /**
     * Test of processDelete method, of class UserService.
     */
    @Test
    public void testProcessDelete() {
        System.out.println("processDelete");
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        instance.processCreate(ur);
        String name = ur.getId();
        //delete created user object from DB
        instance.processDelete(name);
        User result = instance.findUR(ur.getId());
        assertEquals(null, result);   
    }

    /**
     * Test of checkIsAssigned method, of class UserService.
     */
    @Test
    public void testCheckIsAssigned() throws Exception {
        System.out.println("checkIsAssigned");
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        instance.processCreate(ur);
        boolean result = instance.checkIsAssigned(ur);
        assertFalse(result);
        //to delete created user object from DB
        instance.processDelete(ur.getId());
    }

    /**
     * Test of checkIsExist method, of class UserService.
     */
    @Test
    public void testCheckIsExist() throws Exception {
        System.out.println("checkIsExist");
        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role("presenter");
        roles.add(role1);
        User ur = new User("sur", "test", "Dummy the great", roles);
        boolean result = instance.checkIsExist(ur);
        assertFalse(result);    
    }
    
}
