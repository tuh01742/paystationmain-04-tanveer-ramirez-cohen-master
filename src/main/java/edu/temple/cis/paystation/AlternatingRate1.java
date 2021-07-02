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
public class AlternatingRate1 implements RateStrategy {
    Calendar cal = Calendar.getInstance();
    /*will get the current day of the week*/
    int dayVal = cal.get(cal.DAY_OF_WEEK);
    int timeBought;
    
    @Override
    public int calculateTime(int moneyInserted){
        RateStrategy rate;
        if(dayVal == 1 || dayVal == 7){//for weekends
            rate = new Linear1RateStrategy();//sets rate as Linear 1
        }
        
        else{//for weekdays
            rate = new ProgressiveRateStrategy();//sets rate as Progressive
        }
        
        timeBought = rate.calculateTime(moneyInserted);//executes calculateTime based on day of week
        return timeBought;
    }
    
    public void setDay(int day){
        dayVal = day;
    }
    
}
