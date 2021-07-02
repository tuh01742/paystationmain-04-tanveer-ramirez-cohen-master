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
public class AlternatingRateTest2 {
    private AlternatingRate2 rs;
    
    @Before
    public void setUp(){
        rs = new AlternatingRate2();
    }
    
    @Test
    public void timeBoughtShouldBe40WhenInserting100(){
        rs.setDay(3);
        
        assertEquals("The time bought should be equal to 40", 40, rs.calculateTime(100));
    }
}
