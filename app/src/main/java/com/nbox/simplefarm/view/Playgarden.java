package com.nbox.simplefarm.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nbox.simplefarm.GameManager;
import com.nbox.simplefarm.GardenBed;
import com.nbox.simplefarm.GrownThread;
import com.nbox.simplefarm.Player;
import com.nbox.simplefarm.R;
import com.nbox.simplefarm.seeds.FennelSeed;
import com.nbox.simplefarm.seeds.OnionSeed;
import com.nbox.simplefarm.seeds.Seed;

public class Playgarden extends AppCompatActivity implements View.OnClickListener {

    public TextView playerName, playerCash;
    private static Player player = Player.getPlayer();
    ImageView gardenbed1, gardenbed2, gardenbed3;
    GardenBed gardenBed1 = new GardenBed();
    GardenBed gardenBed2 = new GardenBed();
    GardenBed gardenBed3 = new GardenBed();
    GardenBed checkedGardenbed;
    Seed seed;
    Intent intent;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgarden);

        loadGame(player.getName());

        playerName = (TextView) findViewById(R.id.playerName);
        playerCash = (TextView) findViewById(R.id.playerCash);

        playerName.setText(player.getName());
        playerCash.setText(player.getCash() + "$");

        gardenbed1 = (ImageView) findViewById(R.id.gardenbed1);
        gardenbed2 = (ImageView) findViewById(R.id.gardenbed2);
        gardenbed3 = (ImageView) findViewById(R.id.gardenbed3);

        gardenbed1.setOnClickListener(this);
        gardenbed2.setOnClickListener(this);
        gardenbed3.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gardenbed1:
                checkedGardenbed = gardenBed1;
                choseSeed();
                break;

            case R.id.gardenbed2:
                checkedGardenbed = gardenBed2;
                choseSeed();
                break;

            case R.id.gardenbed3:
                checkedGardenbed = gardenBed3;
                choseSeed();
                break;
        }

    }

    private void startGrown(Seed seed) {
        new GrownThread(checkedGardenbed, seed).start();
    }

    private void choseSeed() {
        if (checkedGardenbed.isReadyToHarvest()) {
            new GameManager().harvestPlant(checkedGardenbed);
            playerCash.setText(player.getCash() + "$");
            checkedGardenbed.setReadyToHarvest(false);
        } else if (checkedGardenbed.isSown()) {
            System.out.println("Gardenbed is ready sow! You can not sow again, untill you don't harvest a plant!");
        } else {
            intent = new Intent(this, ChangeSeedForPlanting.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        seed = data.getParcelableExtra("seed");
        playerCash.setText(player.getCash() + "$");
        startGrown(seed);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveGame();
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveGame();
    }


    //Save and load game.
    private void loadGame(String name) {
        preferences = getPreferences(MODE_PRIVATE);
        if (player.getName().equals(name)) {
            player.setCash(preferences.getFloat("playerCash", 0));
            player.setExp(preferences.getInt("playerXP", 0));
        }
    }

    private void saveGame() {
        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("playerName", player.getName());
        editor.putFloat("playerCash", (float) player.getCash());
        editor.putInt("playerXP", player.getExp());
        editor.commit();
    }


}
