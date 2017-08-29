package com.nbox.simplefarm;

import android.content.SharedPreferences;

import com.nbox.simplefarm.seeds.Seed;

import java.util.Calendar;

/**
 * Created by makarov.s on 28.08.2017.
 */

public class GameManager {

    private Player player = Player.getPlayer();


    public boolean plantASeed(GardenBed gardenBed, Seed seed) {
        boolean isPlanted = false;
        System.out.println("Player buy a seed.");
        gardenBed.plantASeed(seed);
        isPlanted = true;
        return isPlanted;
    }

    public void waitForGrowUp(GardenBed gardenBed) {
        Seed seed = gardenBed.getPlantedSeed();
        Calendar now = Calendar.getInstance();
        System.out.println("Wait untill seed is grow up...");
        while (now.getTimeInMillis() + seed.getTimeToGrowUpInMillis() >= Calendar.getInstance().getTimeInMillis()) {

        }
        gardenBed.setReadyToHarvest(true);
        System.out.println("Seed is ready to harvest.");
    }

    public void harvestPlant(GardenBed gardenBed) {
        gardenBed.harvestPlant();
        player.setCash(player.getCash() + gardenBed.getPlantedSeed().getSellPrice());
        player.setExp(player.getExp() + gardenBed.getPlantedSeed().getExp());
        System.out.println(player.getCash() + "$");
        System.out.println(player.getExp() + " EXP");
    }

}
