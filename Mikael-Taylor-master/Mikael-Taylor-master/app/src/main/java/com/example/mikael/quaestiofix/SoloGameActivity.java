package com.example.mikael.quaestiofix;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by mikae on 3/28/2016.
 */
public class SoloGameActivity extends AppCompatActivity{
    private int count = 0;
    private int points = 0;
    private int score = 0;
    private String answer;
    private String difficultyString;
    private String answerValue;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);
        quiz("a0");
        final Button ans1 = (Button) findViewById(R.id.btnans1);
        final Button ans2 = (Button) findViewById(R.id.btnans2);
        final Button ans3 = (Button) findViewById(R.id.btnans3);
        final Button ans4 = (Button) findViewById(R.id.btnans4);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz("a1");
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz("a2");
            }
        });
        ans3.setOnClickListener(new View.OnClickListener(){
          @Override
        public void onClick (View v){
              quiz("a3");
          }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz("a4");
            }
        });
    }


    private void quiz(String chosenAnswer){
        TextView question =(TextView) findViewById(R.id.lblquestion);
        TextView newScore = (TextView) findViewById(R.id.lblscore);
        TextView difficulty = (TextView) findViewById(R.id.lbldifficulty);
        Button answer1 = (Button)findViewById(R.id.btnans1);
        Button answer2 = (Button)findViewById(R.id.btnans2);
        Button answer3 = (Button)findViewById(R.id.btnans3);
        Button answer4=(Button)findViewById(R.id.btnans4);
        String q1 = "Who is the creator of Quaestio?";
        String q1diff="Very Hard";
        String q1correct="Mikael Taylor";
        String q1a1="Mikael Taylor";
        String q1a2="Steve Jobs";
        String q1a3="Rodney Paulson";
        String q1a4="Charles Vayne";
        String q2="What was the Black Pearl named before it was known as the Black Pearl?";
        String q2correct="The Wicked Wench";
        String q2diff="Hard";
        String q2a1="Burley Burgeoness";
        String q2a2="White Waters";
        String q2a3="Painted Pigeon";
        String q2a4="The Wicked Wench";
        String q3="In the hit comic series, The Walking Dead- who was the leader of the Hilltop Community when the main group arrives with Jesus?";
        String q3correct="Gregory";
        String q3diff="Medium";
        String q3a1="Mallory";
        String q3a2="Phil";
        String q3a3="Gregory";
        String q3a4="Jesus";
        String q4="Who was the first president of the United States?";
        String q4correct="George Washington";
        String q4diff="Very Easy";
        String q4a1="Rand Paul";
        String q4a2="George Carver";
        String q4a3="George Washington";
        String q4a4="Theodore Roosevelt";
        String q5="What does the Jolly Roger Flag represent?";
        String q5correct="Piracy";
        String q5diff="Easy";
        String q5a1="Freedom";
        String q5a2="Information security";
        String q5a3="Sailors";
        String q5a4="Piracy";
        if(count == 0){
            score=0;
            difficultyString=q1diff;
            question.setText(q1);
            answer1.setText(q1a1);
            answer2.setText(q1a2);
            answer3.setText(q1a3);
            answer4.setText(q1a4);
            difficulty.setText(q1diff);
            answer=q1correct;
            answerValue="a1";
            count++;
        }else if(count == 1){
            question.setText(q2);
            answer1.setText(q2a1);
            answer2.setText(q2a2);
            answer3.setText(q2a3);
            answer4.setText(q2a4);
            difficulty.setText(q2diff);
            difficultyString=q1diff;
            answer=q2correct;
            answerValue="a2";
            count++;
        } else if (count==2){
            count++;
            question.setText(q3);
            answer1.setText(q3a1);
            answer2.setText(q3a2);
            answer3.setText(q3a3);
            answer4.setText(q3a4);
            difficulty.setText(q3diff);
            difficultyString=q3diff;
            answer=q3correct;
            answerValue="a3";
            count++;
        } else if (count == 3){

            question.setText(q4);
            answer1.setText(q4a1);
            answer2.setText(q4a2);
            answer3.setText(q4a3);
            answer4.setText(q4a4);
            difficulty.setText(q4diff);
            difficultyString=q4diff;
            answer=q4correct;
            answerValue="a3";
            count++;
        }else if (count == 4){

            question.setText(q5);
            answer1.setText(q5a1);
            answer2.setText(q5a2);
            answer3.setText(q5a3);
            answer4.setText(q5a4);
            difficulty.setText(q5diff);
            difficultyString=q5diff;
            answer=q5correct;
            answerValue="a4";
            count++;
        }

        if(answerValue == chosenAnswer && difficultyString =="Very Hard"){
            points = 1000;
        } else if(answerValue == chosenAnswer && difficultyString =="Hard"){
            points = 800;
        } else if (answerValue == chosenAnswer && difficultyString =="Medium"){
            points=600;
        }else if(answerValue == chosenAnswer && difficultyString =="Easy"){
            points=400;
        }else if(answerValue == chosenAnswer && difficultyString =="Very Easy"){
            points= 200;
        }else if(answerValue == "a0") {
            points=0;
            TextView scoreStart = (TextView) findViewById(R.id.lblscore);
            scoreStart.setText(score);
        } else if (count>4){
            TextView q= (TextView) findViewById(R.id.lblquestion);
        q.setText("ALL DONE! YAAAY! Your score was "+score+"!");
        }
        int nextscore= score+points;
        String updateScore= String.valueOf(nextscore+points);
        newScore.setText(updateScore);
        score=nextscore;
    }

}
