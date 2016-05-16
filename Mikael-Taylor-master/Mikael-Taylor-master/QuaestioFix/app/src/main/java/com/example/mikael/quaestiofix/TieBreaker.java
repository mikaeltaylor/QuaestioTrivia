package com.example.mikael.quaestiofix;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TieBreaker extends AppCompatActivity {
String opponentResponse;
    String win;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie_breaker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageButton scissors = (ImageButton) findViewById(R.id.imgBtnScissors);
        ImageButton paper = (ImageButton) findViewById(R.id.imgBtnPaper);
        ImageButton rock = (ImageButton) findViewById(R.id.imgBtnRock);
        scissors.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tieBreaker("scissors");
            }
        });
        rock.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tieBreaker("rock");
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tieBreaker("paper");
            }
        });
    }
    public void tieBreaker(String response){
        TextView result = (TextView) findViewById(R.id.textView);
        opponentResponse = "rock";
if( response == "scissors" && opponentResponse =="rock" || response == "paper" && opponentResponse=="scissors" ||  response == "rock" && opponentResponse =="paper"){
    win = "false";
    result.setText("You lost!");
    //TODO: Send the loss to the server.
    //TODO: Oh, and set up some sort of server?
} else
    if (response =="rock" && opponentResponse == "scissors" ||response == "scissors" && opponentResponse=="paper" || response=="paper" && opponentResponse =="rock"){
        win = "true";
      result.setText("You won!");

        //TODO:Send the win to the server.
        //TODO: Still need to set up a server of some sort?
    }
        else if(response == "scissors" && opponentResponse == "scissors" || response =="paper" &&opponentResponse == "paper" || response =="rock" && opponentResponse =="rock"){
        win ="invalid";
        result.setText("You tied..  again!");
        Intent TieBreaker = new Intent(getApplicationContext(),TieBreaker.class);
        startActivity(TieBreaker);
        //TODO: Reset the activity.
    }

    }
}
