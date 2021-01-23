package com.monstergame.model;

/**
 * This is getting weird, I think I had a good idea, but im not sure anymore...
 * going to leave this craziness, might mess with it later; would require
 * a lot of refactoring to implement
 */


public enum Stats {
    HEALTH,
    STRENGTH,
    INTELLECT,
    SPEED,
    DEFENCE;

    private final int MAX_VALUE = 999;
    private final int MIN_VALUE = 0;
    public int intStat;
    public int doubleStat;
    Stats(){

    }
    Stats(int num){

    }
    Stats(double num){

    }

    private boolean checkValidity(double num){
        return true;
    }
    private boolean checkValidity(int num){
        return true;
    }
}
