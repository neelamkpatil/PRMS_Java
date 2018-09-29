/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import sg.edu.nus.iss.phoenix.user.entity.Role;
import sg.edu.nus.iss.phoenix.user.entity.User;

/**
 *
 * @author Neelam
 */
public class ReviewSelectUserServiceTest {
    
    ReviewSelectUserService instance;
   
    
    @Before
    public void setUp() {
        instance=new ReviewSelectUserService();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of reviewSelectUser method, of class ReviewSelectUserService to check list of users not null.
     */
    @Test
    public void testReviewSelectUser() {
        System.out.println("reviewSelectUser");    
        List<User> result = instance.reviewSelectUser();
        assertNotNull(result);
      
    }

    /**
     * Test of findURByRole method, of class ReviewSelectUserService to check list of users not null when called by role.
     */
    @Test
    public void testFindURByRole() {
        System.out.println("findURByRole");
        String role = "producer";
        
        ArrayList<User> result = instance.findURByRole(role);
        assertNotNull(result);
        
        role = "presenter";
        result = instance.findURByRole(role);
        assertNotNull(result);
        
   
    }

    /**
     * Test of searchUser method, of class ReviewSelectUserService .
     */
    @Test
    public void testSearchUser() {
        System.out.println("searchUser");
        ArrayList<Role> roles=new ArrayList<Role>();
        roles.add(new Role("admin:manager"));
        roles.add(new Role("manager"));
        User ur = new User("catbert","catbert","catbert, the hr",roles);
        List<User> result=instance.searchUser(ur);
        System.out.println("result:"+result);
        assertNotNull(result);
       
    }
    
}
