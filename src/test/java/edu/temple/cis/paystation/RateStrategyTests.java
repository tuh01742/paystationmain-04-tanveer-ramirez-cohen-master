/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.cis.paystation;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author ramir
 */
public class RateStrategyTests {
    private Linear1RateStrategy linear1_rs;
    private Linear2RateStrategy linear2_rs;
    private ProgressiveRateStrategy progressive_rs;
    private AlternatingRate1 alternating1_rs;
    private AlternatingRate2 alternating2_rs;
    
    
    @Before
    public void setUp(){
        
    }
    
    //TESTS FOR ALTERNATING RATE STRATEGY 1
     @Test
    public void weekdayTest(){
        alternating1_rs = new AlternatingRate1();
        alternating1_rs.setDay(2);
        
        assertEquals("Time Bought should be 114", 114, alternating1_rs.calculateTime(330));
        assertEquals("Time Bought should be 44", 44, alternating1_rs.calculateTime(110));
        assertEquals("Time Bought should be 122", 122, alternating1_rs.calculateTime(360));
    }
    
    @Test
    public void weekendTest(){
        alternating1_rs = new AlternatingRate1();
        alternating1_rs.setDay(1);
        
        assertEquals("Time Bought should be 20", 20, alternating1_rs.calculateTime(50));
    }
    
    //TESTS FOR ALTERNATING RATE STRATEGY 2
    @Test
    public void timeBoughtShouldBe40WhenInserting100(){
        alternating2_rs = new AlternatingRate2();
        alternating2_rs.setDay(3);
        
        assertEquals("The time bought should be equal to 40", 40, alternating2_rs.calculateTime(100));
    }
    
    //TESTS FOR LINEAR RATE STRATEGY 1
    /**
     * Entering 200 in coin values should get 80 mins for parking time
     *
     */

    @Test
    public void shouldReturnCorrectTimeFor200Coins() {
        linear1_rs = new Linear1RateStrategy();
        assertEquals("Should display 80 min for 200 coin value", 80, linear1_rs.calculateTime(200));


    }
    
    //TESTS FOR LINEAR RATE STRATEGY 2
    /**
     * Entering 100 in coin values should get 20 mins for parking time
     *
     */

    @Test
    public void shouldReturnCorrectTimeFor100Coins() {
        linear2_rs = new Linear2RateStrategy();
        assertEquals("Should display 20 min for 100 coin value", 20, linear2_rs.calculateTime(100));


    }
    
    //TESTS FOR PROGRESSIVE RATE STRATEGY
     /**
     * Testing for less than an hour (60 Min) so amount <150
     * 145 amount gives 58 min
     */

    @Test
    public void shouldReturn58MinFor145(){
        progressive_rs = new ProgressiveRateStrategy();
        assertEquals("145 should yields 58 min", 58, progressive_rs.calculateTime(145));
    }



    /**
     * Testing: between 1st hour and 2nd hour so 350>amount >=150
     */
    @Test
    public void shouldReturn75MinFor200(){
        progressive_rs = new ProgressiveRateStrategy();
        assertEquals("200 should yields 75 min ", 75, progressive_rs.calculateTime(200));
    }


    /**
     *
     * Testing: greater than 2 hours so amount >= 350
     * 650 cents should yield to 3 hours of parking time
     */
    @Test
    public void shouldReturn180MinFor650(){
        progressive_rs = new ProgressiveRateStrategy();
        assertEquals("650 should yields 180 min ", 180, progressive_rs.calculateTime(650));
    }


    /**
     *
     * Testing: greater than 3 hours so amount >= 350
     * 950 cents should yield to 4 hours of parking time
     */
    @Test
    public void shouldReturn240MinFor950(){
        progressive_rs = new ProgressiveRateStrategy();
        assertEquals("950 should yields 240 min ", 240, progressive_rs.calculateTime(950));
    }
}
