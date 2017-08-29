package com.nbox.simplefarm;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class Player {
    private static String fullName;
    private double cash = 200.00;
    private int exp = 0;
    private static Player player = null;

    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public void setName(String name) {
        fullName = name;
    }

    public String getName() {
        return fullName;
    }

    public double getCash() {
        return cash;
    }

    public int getExp() {
        return exp;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
