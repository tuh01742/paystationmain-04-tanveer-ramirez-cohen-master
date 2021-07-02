package edu.temple.cis.paystation;

public class Linear1RateStrategy implements RateStrategy{


    @Override
    public int calculateTime(int coinValue) {

    return (coinValue*2) /5;



    }
}


