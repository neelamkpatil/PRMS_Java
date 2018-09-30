/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.entity;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Surbhi Tayal
 */
public class UserTest {
    
   
    User instance;
    @Before
    public void setUp() {
        instance=new User();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        instance.setId("test1");
        String result = instance.getId();
        assertEquals(result, "test1");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "test1";
         User instance = new User();
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        ArrayList<Role> roles = new ArrayList();
        Role role = new Role("produce");
        roles.add(role);
        User instance1 = new User("testID","password", "name", roles);
        String result = instance1.getPassword();
        assertEquals(instance1.getPassword(), "password");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String passwordIn = "password";
        instance.setPassword(passwordIn);
        assertEquals(instance.getPassword(), passwordIn);
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "test name";
        instance.setName(expResult); 
        assertEquals(expResult, instance.getName());
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        User instance = new User();
        String expResult = "test name";
        instance.setName(expResult); 
        assertEquals(expResult, instance.getName());
    }

    /**
     * Test of getRoles method, of class User.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        User instance = new User();
        ArrayList<Role> roleList = new ArrayList<>();
        Role role = new Role("manager");
        roleList.add(role);
        instance.setRoles(roleList);
        assertEquals(role.getRole(), instance.getRoles().get(0).getRole());
    }

    /**
     * Test of setRoles method, of class User.
     */
    @Test
    public void testSetRoles() {
        System.out.println("setRoles");
       User instance = new User();
        ArrayList<Role> roleList = new ArrayList<>();
        Role role = new Role("manager");
        roleList.add(role);
        instance.setRoles(roleList);
        assertEquals(role.getRole(), instance.getRoles().get(0).getRole());
    }

    /**
     * Test of setAll method, of class User.
     */
    @Test
    public void testSetAll() {
        System.out.println("setAll");
        String idIn = "testID";
        String passwordIn = "password";
        String nameIn = "test name";
        String roleIn = "test role";
       
        instance.setAll(idIn, passwordIn, nameIn, roleIn);
        assertEquals(instance.getName(), nameIn);
        assertEquals(instance.getId(), idIn);
        assertEquals(instance.getPassword(), passwordIn);
        assertEquals(instance.getRoles().get(0).getRole(), roleIn);
    }

    /**
     * Test of hasEqualMapping method, of class User.
     */
    @Test
    public void testHasEqualMapping() {
        System.out.println("hasEqualMapping");
         ArrayList<Role> roleList = new ArrayList<>();
        Role role = new Role("manager");
        role.setAccessPrivilege("manager");
        roleList.add(role);
        User valueObject = new User("test","password","name", roleList);
        //User mappedObject = new User("test","password","name",roleList);
        boolean expResult = false;
        boolean result = instance.hasEqualMapping(valueObject);
        assertEquals(expResult, result);
    }

}
