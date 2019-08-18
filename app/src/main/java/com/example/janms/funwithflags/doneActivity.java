package com.example.janms.funwithflags;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class doneActivity extends Activity {

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        Intent last = getIntent();
        final byte[] score =last.getByteArrayExtra("Extra_Score");

        TextView scoretxt = findViewById(R.id.scoretxt);
        scoretxt.setText(String.format("Score: %s/10", String.valueOf(score[0])));

        TextView evaluatetxt = findViewById(R.id.evaltxt);

        if(score[0]==10){
            evaluatetxt.setText("Gratulerer!");
        }
        else if(score[0]>7){
            evaluatetxt.setText("Nesten der!");
        }
        else if(score[0]>4){
            evaluatetxt.setText("Midt på treet");
        }
        else if(score[0]>2){
            evaluatetxt.setText("Prøv igjen");
        }
        else{
            evaluatetxt.setText("Helt elendig");
        }

        byte highScore = score[0];
        byte lastHigh = score[3];

        final Intent retry = new Intent(this, MainActivity.class);
        retry.putExtra("Extra_Score", highScore);
        retry.putExtra("Extra_Last", lastHigh);


        Button startbtn = findViewById(R.id.retrybtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(retry);


            }
        });
    }
}
