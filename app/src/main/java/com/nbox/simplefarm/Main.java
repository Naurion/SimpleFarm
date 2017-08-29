package com.nbox.simplefarm;

import com.nbox.simplefarm.seeds.FennelSeed;
import com.nbox.simplefarm.seeds.OnionSeed;
import com.nbox.simplefarm.seeds.Seed;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GardenBed gardenBed1 = new GardenBed();
        Seed seed1 = new FennelSeed();
        GrownThread thread1 = new GrownThread(gardenBed1, seed1);
        thread1.start();

        Thread.sleep(200);

        GardenBed gardenBed2 = new GardenBed();
        Seed seed2 = new OnionSeed();
        GrownThread thread2 = new GrownThread(gardenBed2, seed2);
        thread2.start();

        Thread.sleep(200);

        Seed seed3 = new OnionSeed();
        GrownThread thread3 = new GrownThread(gardenBed2, seed3);
        thread3.start();

    }
}
