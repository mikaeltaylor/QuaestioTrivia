package com.example.mikael.quaestiofix;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sologame = (Button) findViewById(R.id.buttonsologame);
        sologame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent goSoloGame = new Intent(getApplicationContext(),SoloGameActivity.class);
                startActivity(goSoloGame);
                onPause();
                //When the user clicks the New Solo Game button, we want to set up
                // a new solo game for them to play.  Before this is done, we'll need
                // to know if the user wants to play very easy, easy, medium, hard, or
                // impossible difficulty of trivia. We will also need to know the category
                // of trivia they would like to play - Science, History, Geography, Math, Information
                // Technology, Pop Culture, or Random.
                //TODO: Make button open SoloGame activity
                //TODO: Create Difficulty Selection Menu && pass difficultyLevel to SoloGame activity
                //TODO: Create questions&answers database with SQLite for each difficultyLevel and category
                //TODO: Create point system for correct answers
                //TODO: Create Leaderboard for solo game]
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
