package com.example.janms.funwithflags;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent startquiz = new Intent(this, questionActivity.class);
        byte score = 0;
        byte tracker = 0;
        byte maxtrack = 10;
        byte highscore = 0;
        byte[] track = new byte[4];
        track[0] = score;
        track[1] = tracker;
        track[2] = maxtrack;


        String[] usedFlags = new String[maxtrack];
        startquiz.putExtra("Extra_usedFlags", usedFlags);


        //data
        Flag flag1 = new Flag("Albania", R.drawable.europe_albania);
        Flag flag2 = new Flag("Andorra", R.drawable.europe_andorra);
        Flag flag3 = new Flag("Austria", R.drawable.europe_austria);
        Flag flag4 = new Flag("Belarus", R.drawable.europe_belarus);
        Flag flag5 = new Flag("Belgium", R.drawable.europe_belgium);
        Flag flag6 = new Flag("Bosnia", R.drawable.europe_bosnia);
        Flag flag7 = new Flag("Bulgaria", R.drawable.europe_bulgaria);
        Flag flag8 = new Flag("Croatia", R.drawable.europe_croatia);
        Flag flag9 = new Flag("Cyprus", R.drawable.europe_cyprus);
        Flag flag10 = new Flag("Northern Cyprus", R.drawable.europe_cyprus_north);
        Flag flag11 = new Flag("Czech Republic", R.drawable.europe_czech_republic);
        Flag flag12 = new Flag("Denmark", R.drawable.europe_denmark);
        Flag flag13 = new Flag("Estonia", R.drawable.europe_estonia);
        Flag flag14 = new Flag("Faroe Islands", R.drawable.europe_faroe_islands);
        Flag flag15 = new Flag("Finland", R.drawable.europe_finland);
        Flag flag16 = new Flag("France", R.drawable.europe_france);
        Flag flag17 = new Flag("Germany", R.drawable.europe_germany);
        Flag flag18 = new Flag("Gibraltar", R.drawable.europe_gibraltar);
        Flag flag19 = new Flag("Greece", R.drawable.europe_greece);
        Flag flag20 = new Flag("Greenland", R.drawable.europe_greenland);
        Flag flag21 = new Flag("Hungary", R.drawable.europe_hungary);
        Flag flag22 = new Flag("Iceland", R.drawable.europe_iceland);
        Flag flag23 = new Flag("Ireland", R.drawable.europe_ireland);
        Flag flag24 = new Flag("Italy", R.drawable.europe_italy);
        Flag flag25 = new Flag("Latvia", R.drawable.europe_latvia);
        Flag flag26 = new Flag("Liechtenstein", R.drawable.europe_liechtenstein);
        Flag flag27 = new Flag("Lithuania", R.drawable.europe_lithuania);
        Flag flag28 = new Flag("Luxembourg", R.drawable.europe_luxembourg);
        Flag flag29 = new Flag("Macedonia", R.drawable.europe_macedonia);
        Flag flag30 = new Flag("Malta", R.drawable.europe_malta);
        Flag flag31 = new Flag("Moldova", R.drawable.europe_moldova);
        Flag flag32 = new Flag("Monaco", R.drawable.europe_monaco);
        Flag flag33 = new Flag("Netherlands", R.drawable.europe_netherlands);
        Flag flag34 = new Flag("Norway", R.drawable.europe_norway);
        Flag flag35 = new Flag("Poland", R.drawable.europe_poland);
        Flag flag36 = new Flag("Portugal", R.drawable.europe_portugal);
        Flag flag37 = new Flag("Romania", R.drawable.europe_romania);
        Flag flag38 = new Flag("Russia", R.drawable.europe_russia);
        Flag flag39 = new Flag("San Marino", R.drawable.europe_san_marino);
        Flag flag40 = new Flag("Serbia", R.drawable.europe_serbia);
        Flag flag41 = new Flag("Slovakia", R.drawable.europe_slovakia);
        Flag flag42 = new Flag("Slovenia", R.drawable.europe_slovenia);
        Flag flag43 = new Flag("Spain", R.drawable.europe_spain);
        Flag flag44 = new Flag("Sweden", R.drawable.europe_sweden);
        Flag flag45 = new Flag("Switzerland", R.drawable.europe_switzerland);
        Flag flag46 = new Flag("Ukraine", R.drawable.europe_ukraine);
        Flag flag47 = new Flag("United Kingdom", R.drawable.europe_united_kingdom);
        Flag flag48 = new Flag("Vatican City", R.drawable.europe_vatican_city);
        //Flag flag49 = new Flag("", R.drawable.);



        Intent finish = getIntent();
        byte lastscore = finish.getByteExtra("Extra_Score", (byte)0);
        byte lastHigh = finish.getByteExtra("Extra_Last", (byte)0);

        TextView highscoretxt = findViewById(R.id.scoretxt);


        if(lastscore>lastHigh){
            highscoretxt.setText(String.valueOf(lastscore));
            highscore = lastscore;
        }
        else if(lastscore<=lastHigh){
            highscoretxt.setText(String.valueOf(lastHigh));
            highscore = lastHigh;
        }

        track[3] = highscore;
        startquiz.putExtra("Extra_Track", track);

        Button startbtn = findViewById(R.id.startbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(startquiz);


            }
        });

    }
}
