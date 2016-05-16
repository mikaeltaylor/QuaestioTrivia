package com.example.mikael.quaestiofix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class multiplayer_quickgame extends AppCompatActivity {
    private int count = 0;
    private int points = 0;
    private int score = 0;
    private String difficultyString;
    public String answerValue;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_quickgame);
        quiz("a0");
        final Button ans1 = (Button) findViewById(R.id.btnAns1);
        final Button ans2 = (Button) findViewById(R.id.btnAns2);
        final Button ans3 = (Button) findViewById(R.id.btnAns3);
        final Button ans4 = (Button) findViewById(R.id.btnAns4);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnText=ans1.getText().toString();
                quiz(btnText);
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String btnText=ans2.getText().toString();
                quiz(btnText);
            }
        });
        ans3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                String btnText=ans3.getText().toString();
                quiz(btnText);
            }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String btnText=ans4.getText().toString();
                quiz(btnText);
            }
        });
    }


    private void quiz(String chosenAnswer){
        TextView quest =(TextView) findViewById(R.id.textView3);
        TextView newScore = (TextView) findViewById(R.id.textView4);
        Button answer1 = (Button)findViewById(R.id.btnAns1);
        Button answer2 = (Button)findViewById(R.id.btnAns2);
        Button answer3 = (Button)findViewById(R.id.btnAns3);
        Button answer4=(Button)findViewById(R.id.btnAns4);
//Trivia list
        ArrayList<String> trivia = new ArrayList<>();
        trivia.add( "How many hydrogen atoms are in one molecule of water?");
        trivia.add( "Hard");
        trivia.add( "Two");
        trivia.add("One");
        trivia.add("Eight");
        trivia.add("Two");
        trivia.add("Five");
        trivia.add( "Orson Welles provided the voice for which Transformer in the movie The Transformers: the Movie released in 1986?");
        trivia.add( "Very Hard");
        trivia.add( "Unicron");
        trivia.add("Megatron");
        trivia.add("Bumblebee");
        trivia.add("Metatron");
        trivia.add("Unicron");
        trivia.add( "Which US President was known as The Great Communicator?");
        trivia.add( "Easy");
        trivia.add( "Ronald Regan");
        trivia.add("Ronald Regan");
        trivia.add("John F. Kennedy");
        trivia.add("Franklin Roosevelt");
        trivia.add("Dwight D. Eisenhauer");
        trivia.add( "What is a traditional fermented Korean side dish made with seasoned vegetables and salt?");
        trivia.add( "Very Hard");
        trivia.add( "Kimchi");
        trivia.add("Aichi");
        trivia.add("Saki");
        trivia.add("Palito");
        trivia.add("Kimchi");
        trivia.add( "Catalonia is a region of what country?");
        trivia.add( "Very Hard");
        trivia.add( "Spain");
        trivia.add("Germany");
        trivia.add("France");
        trivia.add("Spain");
        trivia.add("Italy");
        if(count == 0){
            difficultyString=trivia.get(count+1);
            quest.setText(trivia.get(count));
            answer1.setText(trivia.get(count+3));
            answer2.setText(trivia.get(count+4));
            answer3.setText(trivia.get(count+5));
            answer4.setText(trivia.get(count+6));
            answerValue=trivia.get(count+2);
            score= score+points;
            String updateScore= String.valueOf(score);
            newScore.setText(updateScore);
            count++;
        }else if(count <= 4 && count > 0){
            int stringCount=count*7;
            difficultyString=trivia.get(stringCount+1);
            quest.setText(trivia.get(stringCount));
            answer1.setText(trivia.get(stringCount+3));
            answer2.setText(trivia.get(stringCount+4));
            answer3.setText(trivia.get(stringCount+5));
            answer4.setText(trivia.get(stringCount+6));

            if(answerValue.equals(chosenAnswer)) {
                points = 100;
                score = score + points;
            }
            String scoreString = String.valueOf(score);
            newScore.setText(scoreString);
            answerValue=trivia.get(stringCount+2);
            count++;
        } else if(count>4){
            String doneText="ALL DONE! YAAAY! Your score was "+score+"!";
            opponentBehaviour(score);
            quest.setText(doneText);
            finish();
        }
    }

    private void opponentBehaviour(int score){
        TextView txtOpponentScore = (TextView) findViewById(R.id.textView5);
        TextView quest = (TextView) findViewById(R.id.textView3);
        Random random = new Random();
        int decision = random.nextInt(3);
        int opponentScore;
        if(decision == 2){
         opponentScore = 2500;
            String opppScoreText =" Your opponent's score: "+opponentScore;
            String oppScoreText = "Aw, you lost! Your opponent's score: "+opponentScore;
            quest.setText(oppScoreText);
            txtOpponentScore.setText(opppScoreText);
        } else if(decision == 3){
          opponentScore = 0;
            String opppScoreText =" Your opponent's score: "+opponentScore;
            String oppScoreText = "You won! Your opponent's score: "+opponentScore;
            quest.setText(oppScoreText);
            txtOpponentScore.setText(opppScoreText);
        } else {
        opponentScore = score;
            quest.setText("PREPARE FOR THE TIEBREAKER! Your opponent's score: "+opponentScore);
            String oppScoreText = "Your opponent's score: "+opponentScore;
            txtOpponentScore.setText(oppScoreText);
            Intent TieBreaker = new Intent(getApplicationContext(),TieBreaker.class);
            startActivity(TieBreaker);
            onPause();
        }
    }

}
