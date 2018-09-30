/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radioprogram.service;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Neelam
 */
public class ReviewSelectProgramServiceTest {
    
     ReviewSelectProgramService instance;
    @Before
    public void setUp() {
        instance= new ReviewSelectProgramService();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of reviewSelectRadioProgram method, of class ReviewSelectProgramService.
     */
    @Test
    public void testReviewSelectRadioProgram() {
        System.out.println("reviewSelectRadioProgram");
     
        List<RadioProgram> result = instance.reviewSelectRadioProgram();
        assertNotNull(result);
        
    }
    
}
