/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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
public class ScheduleServiceTest {
    
   ScheduleService instance;
    
    @Before
    public void setUp() {
        instance= new ScheduleService();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }

    /**
     * Test of findAllPS method, of class ScheduleService to test list is not null.
     */
    @Test
    public void testFindAllPS() {
        System.out.println("findAllPS");
        ArrayList<ProgramSlot> result = instance.findAllPS();
        assertNotNull(result);
    }

    /**
     * Test of processCreate method, of class ScheduleService to check if given program slot created.
     * Note: this test case should run successfully if 'id' of program slot is not already present.
     * please do check and change 'id' before running test case.
     */
    @Test
    public void testProcessCreate() {
        System.out.println("processCreate");
        String rpname = "opinions";
        String date1 = "2018-11-25";
        Date date = Date.valueOf(date1);
        Time sttime = new Time(20,00,00);
        Time duration = new Time(20,00,00);
        String presenter = "dilbert";
        String producer = "dilbert";
        int id=6;
        ProgramSlot ps = new ProgramSlot(id,rpname,date,sttime,duration,presenter,producer);
        ScheduleService instance = new ScheduleService();
        boolean expResult = true;
        boolean result = instance.processCreate(ps);
        System.out.println("createresult "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of processModify method, of class ScheduleService to test update is successful or not.
     */
    @Test
    public void testProcessModify() {
        System.out.println("processModify");
        String rpname = "news";
        String date2 = "2018-10-03";
        Date date = Date.valueOf(date2);
        Time sttime = new Time(8,00,00);
        Time duration = new Time(9,00,00);
        String presenter = "dilbert";
        String producer = "wally";
        ProgramSlot ps = new ProgramSlot(2,rpname,date,sttime,duration,presenter,producer);
        ScheduleService instance = new ScheduleService();
        boolean expResult = true;
        boolean result = instance.processModify(ps);
        assertEquals(expResult, result);
    }

    /**
     * Test of processDelete method, of class ScheduleService to test program slot deleted successfully.
     */
    @Test
    public void testProcessDelete() {
       System.out.println("processDelete");
        int id = 7;
        List<ProgramSlot> listBefore = instance.findAllPS();
        ScheduleService instance = new ScheduleService();
        instance.processDelete(id);
        List<ProgramSlot> listAfter = instance.findAllPS();
        assertNotEquals(listBefore.size(),listAfter.size());
    }
    
}
