package com.nbox.simplefarm.seeds;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class OnionSeed extends Seed {

    public static final double BUY_PRICE = 20.00;
    public static final double SELL_PRICE = 35.00;
    public static final int EXP = 15;
    public static final int TIME_TO_GROW_UP_IN_MILLIS = 6500;

    public OnionSeed() {
        super(BUY_PRICE, SELL_PRICE, EXP, TIME_TO_GROW_UP_IN_MILLIS);
    }
}
