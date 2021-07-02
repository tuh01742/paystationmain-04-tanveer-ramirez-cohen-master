package edu.temple.cis.paystation;


import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class Linear2RateStrategyTest {
    private RateStrategy rs;

    @Before
    public void setUp(){
        rs = new Linear2RateStrategy();
    }

    /**
     * Entering 100 in coin values should get 20 mins for parking time
     *
     */

    @Test
    public void shouldReturnCorrectTimeFor100Coins() {

        assertEquals("Should display 20 min for 100 coin value", 20, rs.calculateTime(100));


    }
}
