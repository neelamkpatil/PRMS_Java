/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

/**
 *
 * @author Neelam
 */
public class ReviewSelectScheduleServiceTest {
    
    ReviewSelectScheduleService instance;
   
   
    @Before
    public void setUp() {
        instance = new ReviewSelectScheduleService();
    }
    
    @After
    public void tearDown() {
       instance=null;
    }

    /**
     * Test of reviewSelectSchedule method, of class ReviewSelectScheduleService for not null.
     */
    @Test
    public void testReviewSelectSchedule() {
        System.out.println("reviewSelectSchedule");
        
       
        List<ProgramSlot> result = instance.reviewSelectSchedule();
        assertNotNull(result);
        
    }
    
}
