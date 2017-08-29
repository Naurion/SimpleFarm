package com.nbox.simplefarm.seeds;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class Seed implements Parcelable {
    private double buyPrice;
    private double sellPrice;
    private int exp;
    private long timeToGrowUpInMillis;


    public Seed(double buyPrice, double sellPrice, int exp, long timeToGrowUpInMillis) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.exp = exp;
        this.timeToGrowUpInMillis = timeToGrowUpInMillis;
    }

    protected Seed(Parcel in) {
        buyPrice = in.readDouble();
        sellPrice = in.readDouble();
        exp = in.readInt();
        timeToGrowUpInMillis = in.readLong();
    }

    public static final Creator<Seed> CREATOR = new Creator<Seed>() {
        @Override
        public Seed createFromParcel(Parcel in) {
            return new Seed(in);
        }

        @Override
        public Seed[] newArray(int size) {
            return new Seed[size];
        }
    };

    public double getBuyPrice() {

        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public int getExp() {
        return exp;
    }

    public long getTimeToGrowUpInMillis() {
        return timeToGrowUpInMillis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(buyPrice);
        dest.writeDouble(sellPrice);
        dest.writeInt(exp);
        dest.writeLong(timeToGrowUpInMillis);
    }
}
