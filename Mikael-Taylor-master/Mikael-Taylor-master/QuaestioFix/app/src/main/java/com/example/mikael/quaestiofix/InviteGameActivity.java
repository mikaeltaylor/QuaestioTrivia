package com.example.mikael.quaestiofix;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class InviteGameActivity extends AppCompatActivity {

    int userScore;
    int opponentScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//TODO: Figure out how to utilize multiplayer, and compare scores.
//TODO: Do the previous step, but without having to pay $25 to Google Play Services..
//TODO: Add categorical trivia.
// TODO: Implement leaderboard.
    }

    public void tieBreaker(){
    //TODO: Implement rock/paper/scissors minigame for tiebreaker
    //TODO: Add win screen
        if(userScore == opponentScore ) {
        Intent goTieBreaker = new Intent(getApplicationContext(), TieBreaker.class);
            startActivity(goTieBreaker);
            onPause();
        }


    }

}
