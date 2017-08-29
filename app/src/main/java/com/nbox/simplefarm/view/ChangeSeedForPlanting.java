package com.nbox.simplefarm.view;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nbox.simplefarm.Player;
import com.nbox.simplefarm.R;
import com.nbox.simplefarm.seeds.FennelSeed;
import com.nbox.simplefarm.seeds.OnionSeed;
import com.nbox.simplefarm.seeds.Seed;

public class ChangeSeedForPlanting extends AppCompatActivity {

    Button buyFennelSeed, buyOnionSeed;
    Seed seed;
    Intent intent = new Intent();
    Player player = Player.getPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_seed_for_planting);

        buyFennelSeed = (Button) findViewById(R.id.buyFennelSeed);
        buyOnionSeed = (Button) findViewById(R.id.buyOnionSeed);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buyFennelSeed:
                        seed = new FennelSeed();
                        sendResult(seed);
                        break;
                    case R.id.buyOnionSeed:
                        seed = new OnionSeed();
                        sendResult(seed);
                        break;

                }
            }
        };

        buyFennelSeed.setOnClickListener(onClickListener);
        buyOnionSeed.setOnClickListener(onClickListener);
    }

    private void sendResult(Seed seed) {
        intent.putExtra("seed", seed);
        setResult(RESULT_OK, intent);
        player.setCash(player.getCash() - seed.getBuyPrice());
        finish();

    }

}
