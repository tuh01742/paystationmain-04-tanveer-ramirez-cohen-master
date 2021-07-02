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
public class AlternatingRate1Test {
    private AlternatingRate1 rs;
    
    @Before
    public void setUp(){
        rs = new AlternatingRate1();
    }
    
    @Test
    public void weekdayTest(){
        rs.setDay(2);
        
        assertEquals("Time Bought should be 114", 114, rs.calculateTime(330));
        assertEquals("Time Bought should be 44", 44, rs.calculateTime(110));
        assertEquals("Time Bought should be 122", 122, rs.calculateTime(360));
    }
    
    @Test
    public void weekendTest(){
        rs.setDay(1);
        
        assertEquals("Time Bought should be 20", 20, rs.calculateTime(50));
    }
}
