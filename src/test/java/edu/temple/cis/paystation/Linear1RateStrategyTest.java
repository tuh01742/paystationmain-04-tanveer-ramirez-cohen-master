package edu.temple.cis.paystation;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class Linear1RateStrategyTest {
    private RateStrategy rs;

    @Before
    public void setUp(){
        rs = new Linear1RateStrategy();
    }

    /**
     * Entering 200 in coin values should get 80 mins for parking time
     *
     */

    @Test
    public void shouldReturnCorrectTimeFor200Coins() {

        assertEquals("Should display 80 min for 200 coin value", 80, rs.calculateTime(200));


    }




}
