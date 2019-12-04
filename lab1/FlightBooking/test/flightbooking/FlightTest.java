/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Hage
 */
public class FlightTest {
    
    public FlightTest() {
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
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        boolean gotEx;
        Flight instance = new Flight(1030,"Toronto","Los Angeles","03/02/99 7:50pm", 3, 100.00);
        String expResult = ("Flight 1030, Toronto to Los Angeles, 03/02/99 7:50pm, original price: $100.0.");
        System.out.println(expResult);
        String result = instance.toString();//breaks here
        System.out.println(result);
        gotEx = expResult.equals(result);
        assertTrue(gotEx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testInvalidConstructor(){
        boolean gotEx = false;
        try{
            Flight f1 = new Flight(1,"Toronto", "Toronto", "03/02/99 7:30pm", 
            100, 500);
        }
        catch(IllegalArgumentException ex){
            gotEx = true;
        }
        assertTrue(gotEx);
    }
    
    
    @Test
    public void testGetSetFlightNumber(){
        
    }
}
