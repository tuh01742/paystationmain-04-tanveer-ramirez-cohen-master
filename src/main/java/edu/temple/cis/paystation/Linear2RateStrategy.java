package edu.temple.cis.paystation;

public class Linear2RateStrategy implements RateStrategy {


    @Override
    public int calculateTime(int coinValue) {


        return coinValue / 5;

    }
}
