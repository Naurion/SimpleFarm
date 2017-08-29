package com.nbox.simplefarm.seeds;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class FennelSeed extends Seed {

    private static final double BUY_PRICE = 10.00;
    private static final double SELL_PRICE = 15.00;
    private static final int EXP = 10;
    private static final int TIME_TO_GROW_UP_IN_MILLIS = 5000;

    public FennelSeed() {
        super(BUY_PRICE, SELL_PRICE, EXP, TIME_TO_GROW_UP_IN_MILLIS);
    }

}
