package edu.temple.cis.paystation;


import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class ProgressiveRateStrategyTest {
    private ProgressiveRateStrategy rs;

    @Before
    public void setUp(){
        rs = new ProgressiveRateStrategy();
    }


    /**
     * Testing for less than an hour (60 Min) so amount <150
     * 145 amount gives 58 min
     */

    @Test
    public void shouldReturn58MinFor145(){

        assertEquals("145 should yields 58 min", 58, rs.calculateTime(145));
    }



    /**
     * Testing: between 1st hour and 2nd hour so 350>amount >=150
     */
    @Test
    public void shouldReturn75MinFor200(){
        assertEquals("200 should yields 75 min ", 75, rs.calculateTime(200));
    }


    /**
     *
     * Testing: greater than 2 hours so amount >= 350
     * 650 cents should yield to 3 hours of parking time
     */
    @Test
    public void shouldReturn180MinFor650(){
        assertEquals("650 should yields 180 min ", 180, rs.calculateTime(650));
    }


    /**
     *
     * Testing: greater than 3 hours so amount >= 350
     * 950 cents should yield to 4 hours of parking time
     */
    @Test
    public void shouldReturn240MinFor950(){
        assertEquals("950 should yields 240 min ", 240, rs.calculateTime(950));
    }


}
