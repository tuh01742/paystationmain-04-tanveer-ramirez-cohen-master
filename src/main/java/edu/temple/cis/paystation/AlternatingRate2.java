/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.cis.paystation;
import java.util.*;
/**
 *
 * @author ramir
 */
public class AlternatingRate2 implements RateStrategy {
    Calendar cal = Calendar.getInstance();
    /*will get the current day of the week*/
    int dayVal = cal.get(cal.DAY_OF_WEEK);
    int timeBought = 0;
    
    @Override
    public int calculateTime(int moneyInserted){
        RateStrategy rate;
        if(dayVal == 1 || dayVal == 7){//for weekends
            System.out.println("All Time is Free on the Weekend, Please Cancel the Service");
        }
        
        else{//for weekdays
            rate = new Linear1RateStrategy();//sets rate as Linear 1
            timeBought = rate.calculateTime(moneyInserted);//executes calculateTime based on day of week
        }
        return timeBought;
    }
    
    public void setDay(int day){
        dayVal = day;
    }
    
}