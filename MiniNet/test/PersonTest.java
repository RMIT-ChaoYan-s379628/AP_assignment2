/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class PersonTest {
    
    public PersonTest() {
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

    /**
     * Test of setImage method, of class Person.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        String strImage = "";
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        instance.setImage(strImage);
        assertEquals("", instance.getImage());
    }

    /**
     * Test of setStatus method, of class Person.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String strStatus = "working";
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        instance.setStatus(strStatus);
        assertEquals("working", instance.getStatus());
    }

    /**
     * Test of setSex method, of class Person.
     */
    @Test
    public void testSetSex() {
        System.out.println("setSex");
        String strSex = "M";
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        instance.setSex(strSex);
        assertEquals("M", instance.getSex());
    }

    /**
     * Test of setState method, of class Person.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String strState = "WA";
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        instance.setState(strState);
        assertEquals(strState, instance.getState());
    }

    /**
     * Test of getAge method, of class Person.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        int expResult = 6;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        String expResult = "Lucy";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImage method, of class Person.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        String expResult = "";
        String result = instance.getImage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Person.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSex method, of class Person.
     */
    @Test
    public void testGetSex() {
        System.out.println("getSex");
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        String expResult = "F";
        String result = instance.getSex();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class Person.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Person instance = new Person("Lucy", 6, "", "", "F", "VIC");
        String expResult = "VIC";
        String result = instance.getState();
        assertEquals(expResult, result);
    }
    
}
