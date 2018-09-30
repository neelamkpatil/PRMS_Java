/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.entity;

import java.sql.Date;
import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neelam
 */
public class ProgramSlotTest {
 
   
    ProgramSlot instance;
    @Before
    public void setUp() {
        instance=new ProgramSlot();
    }
    
    @After
    public void tearDown() {
        instance=null;
    }
    

    /**
     * Test of getId method, of class ProgramSlot.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ProgramSlot instance = new ProgramSlot();
        int expResult = 2;
        instance.setId(2);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class ProgramSlot.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 2;
        ProgramSlot instance = new ProgramSlot();
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of getRpname method, of class ProgramSlot.
     */
    @Test
    public void testGetRpname() {
         System.out.println("getRpname");
        ProgramSlot instance = new ProgramSlot();
        String expResult = "football";
        instance.setRpname("football");
        String result = instance.getRpname();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRpname method, of class ProgramSlot.
     */
    @Test
    public void testSetRpname() {
        System.out.println("setRpname");
        String rpname = "football";
        ProgramSlot instance = new ProgramSlot();
        instance.setRpname(rpname);
        assertEquals(instance.getRpname(), rpname); 
    }

    /**
     * Test of getDate method, of class ProgramSlot.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        ProgramSlot instance = new ProgramSlot();
        Date expResult = new Date(2018-10-02);
        instance.setDate(expResult);
        Date result = instance.getDate();
        assertEquals(expResult, result);   
    }

    /**
     * Test of setDate method, of class ProgramSlot.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = new Date(2018-10-02);
        instance.setDate(date);
        assertEquals(instance.getDate(), date);
    }

    /**
     * Test of getSttime method, of class ProgramSlot.
     */
    @Test
    public void testGetSttime() {
       System.out.println("getSttime");
        ProgramSlot instance = new ProgramSlot();
        Time expResult = new Time(19,00,00);
        instance.setSttime(expResult);
        Time result = instance.getSttime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSttime method, of class ProgramSlot.
     */
    @Test
    public void testSetSttime() {
        System.out.println("getSttime");
        ProgramSlot instance = new ProgramSlot();
        Time expResult = new Time(19,00,00);
        instance.setSttime(expResult);
        Time result = instance.getSttime();
        assertEquals(expResult, result); 
    }

    /**
     * Test of getDuration method, of class ProgramSlot.
     */
    @Test
    public void testGetDuration() {
       System.out.println("getDuration");
        ProgramSlot instance = new ProgramSlot();
        Time expResult = null;
        Time result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDuration method, of class ProgramSlot.
     */
    @Test
    public void testSetDuration() {
       System.out.println("setDuration");
        Time duration = new Time(0,30,00);
        ProgramSlot instance = new ProgramSlot();
        instance.setDuration(duration);
        Time result = instance.getDuration();
        assertEquals(result, duration);
    }

    /**
     * Test of getPresenter method, of class ProgramSlot.
     */
    @Test
    public void testGetPresenter() {
        System.out.println("getPresenter");
        ProgramSlot instance = new ProgramSlot();
        String expResult = "John";
        instance.setPresenter("John");
        String result = instance.getPresenter();
        assertEquals(expResult, result); 
    }

    /**
     * Test of setPresenter method, of class ProgramSlot.
     */
    @Test
    public void testSetPresenter() {
        System.out.println("setPresenter");
        String presenter = "John";
        ProgramSlot instance = new ProgramSlot();
        instance.setPresenter(presenter);
        assertEquals(instance.getPresenter(), presenter);
    }

    /**
     * Test of getProducer method, of class ProgramSlot.
     */
    @Test
    public void testGetProducer() {
       System.out.println("getProducer");
        ProgramSlot instance = new ProgramSlot();
        String expResult = "Mio";
        instance.setProducer("Mio");
        String result = instance.getProducer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProducer method, of class ProgramSlot.
     */
    @Test
    public void testSetProducer() {
        System.out.println("setProducer");
        String producer = "Mio";
        instance.setProducer(producer);
        assertEquals(instance.getProducer(), producer);
    }

    /**
     * Test of setAll method, of class ProgramSlot.
     */
    @Test
    public void testSetAll() {
        System.out.println("setAll");
        int idIn = 1;
        String rpnameIn = "news";
        Date dateIn = new Date(2018-10-02);
        Time sttimeIn = new Time(8,00,00);
        Time durationIn = new Time(0,30,00);;
        String presenterIn = "John";
        String producerIn = "Robert";
        instance.setAll(idIn, rpnameIn, dateIn, sttimeIn, durationIn, presenterIn, producerIn);
        
        //assert values set for all attributes
        int id=instance.getId();
        assertEquals(idIn,id);
        String rpname=instance.getRpname();
        assertEquals(rpnameIn,rpname);
        Date date=instance.getDate();
        assertEquals(dateIn,date);
        Time sttime=instance.getSttime();
        assertEquals(sttimeIn,sttime);
        Time duration=instance.getDuration();
        assertEquals(durationIn,duration);
        String presenter=instance.getPresenter();
        assertEquals(presenterIn,presenter);
        String producer=instance.getProducer();
        assertEquals(producerIn,producer);
        
    }

    /**
     * Test of hasEqualMapping method, of class ProgramSlot.
     */
    @Test
    public void testHasEqualMapping() {
        System.out.println("hasEqualMapping");
        ProgramSlot valueObject = new ProgramSlot(1,"dance",new Date(2018-10-02),new Time(8,00,00),new Time(0,30,00),"John","Robert");
        ProgramSlot mappedObject = new ProgramSlot(1,"dance",new Date(2018-10-02),new Time(8,00,00),new Time(0,30,00),"John","Robert");
        boolean expResult = true;
        boolean result = mappedObject.hasEqualMapping(valueObject);
        assertEquals(expResult, result);
        
        //scenario 2
        expResult=false;
        result=instance.hasEqualMapping(valueObject);
        assertEquals(expResult,result);
        
    }

   

    
}
