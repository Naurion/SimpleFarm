package com.nbox.simplefarm;

import com.nbox.simplefarm.seeds.Seed;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class GrownThread extends Thread {

    GameManager gm = new GameManager();
    GardenBed gardenBed = new GardenBed();
    Seed seed;

    public GrownThread(GardenBed gardenBed, Seed seed) {
        this.gardenBed = gardenBed;
        this.seed = seed;
    }

    public void run() {
       if (gm.plantASeed(gardenBed, seed)) {
           gm.waitForGrowUp(gardenBed);
       }
    }
}
