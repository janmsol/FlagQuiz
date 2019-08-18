package com.example.janms.funwithflags;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class questionActivity extends Activity {

    @Override
    public void onBackPressed() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent last = getIntent();
        String[] usedFlags = last.getStringArrayExtra("Extra_usedFlags");
        final byte[] track =last.getByteArrayExtra("Extra_Track");

        Button answer1 = findViewById(R.id.answer1btn);
        Button answer2 = findViewById(R.id.answer2btn);
        Button answer3 = findViewById(R.id.answer3btn);
        Button answer4 = findViewById(R.id.answer4btn);

        Flag rightAnswer = null;
        List<String> check;
        while(rightAnswer==null) {
            check = Arrays.asList(usedFlags);
            Flag newanswer = FlagRegister.pickFlag();
            if(!check.contains(newanswer.getCountry())){
                rightAnswer = newanswer;
                usedFlags[track[1]] = newanswer.getCountry();
            }
        }



        String[] alternatives = FlagRegister.optionList(rightAnswer);

        ImageView flagimg = findViewById(R.id.flagimg);
        flagimg.setImageResource(rightAnswer.getFlag());




        answer1.setText(alternatives[0]);
        answer2.setText(alternatives[1]);
        answer3.setText(alternatives[2]);
        answer4.setText(alternatives[3]);

        Button[] answers = new Button[4];

        answers[0] = answer1;
        answers[1] = answer2;
        answers[2] = answer3;
        answers[3] = answer4;




        track[1]++;

        TextView scoretxt = findViewById(R.id.scoretxt);
        scoretxt.setText(String.format("Score: %s/10 Question: %s/10", String.valueOf(track[0]), String.valueOf(track[1])));

        final Intent next = new Intent(this, questionActivity.class);
        final Intent done = new Intent(this, doneActivity.class);

        next.putExtra("Extra_usedFlags", usedFlags);

        for(int i=0; i<4; i++){
            if(track[1]==track[2]){
                if (answers[i].getText() == rightAnswer.getCountry()) {
                    answers[i].setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            track[0]++;
                            done.putExtra("Extra_Score", track);
                            startActivity(done);
                        }
                    });
                } else {
                    answers[i].setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            done.putExtra("Extra_Score", track);
                            startActivity(done);
                        }
                    });
                }

            }
            else {
                if (answers[i].getText() == rightAnswer.getCountry()) {
                    answers[i].setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            track[0]++;
                            next.putExtra("Extra_Track", track);
                            startActivity(next);
                        }
                    });
                } else {
                    answers[i].setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            next.putExtra("Extra_Track", track);
                            startActivity(next);
                        }
                    });
                }
            }
        }

    }
}
