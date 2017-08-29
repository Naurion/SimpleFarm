package com.nbox.simplefarm.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.nbox.simplefarm.Player;
import com.nbox.simplefarm.R;

public class Login extends AppCompatActivity {

    EditText playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        playerName = (EditText) findViewById(R.id.playerName);
    }

    public void onClick(View view) {
        Player player = Player.getPlayer();
        player.setName(playerName.getText().toString());
        Intent intent = new Intent(this, Playgarden.class);
        startActivity(intent);
    }
}
