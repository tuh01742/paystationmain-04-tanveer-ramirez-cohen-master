package edu.temple.cis.paystation;

public class ProgressiveRateStrategy implements RateStrategy {

    @Override
    public int calculateTime(int coinValue) {
        int time = 0;

        if(coinValue >= 350){
            coinValue = coinValue -350;
            time = 120 + coinValue / 5;



        }else if(coinValue >= 150 ){
            coinValue = coinValue - 150;
            time =  60 + coinValue /10 * 3;


        }else {
            time = coinValue / 5 * 2;  //default rate strategy
        }

        return time;
    }
}
