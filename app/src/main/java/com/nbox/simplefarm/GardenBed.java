package com.nbox.simplefarm;

import com.nbox.simplefarm.seeds.Seed;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class GardenBed {
    private boolean isSown = false;
    private boolean isReadyToHarvest = false;
    private Seed plantedSeed;

    public boolean isReadyToHarvest() {
        return isReadyToHarvest;
    }

    public void setReadyToHarvest(boolean readyToHarvest) {
        isReadyToHarvest = readyToHarvest;
    }



    public boolean isSown() {
        return isSown;
    }

    public void plantASeed(Seed seed) {
        System.out.println("Seed is planted.");
        this.plantedSeed = seed;
        isSown = true;
    }

    public void harvestPlant() {
        isSown = false;
        System.out.println("Seed is harvest.");
    }

    public Seed getPlantedSeed() {
        return plantedSeed;
    }
}
