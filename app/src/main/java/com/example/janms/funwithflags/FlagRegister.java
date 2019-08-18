package com.example.janms.funwithflags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class FlagRegister {
    static private ArrayList<Flag> flaglist = new ArrayList<>();
    static Random rand = new Random();


    static public ArrayList<Flag> getlist(){
        return flaglist;
    }

    static public Flag pickFlag() {
        int select = rand.nextInt(getlist().size());
        Flag randFlag = getlist().get(select);

        return randFlag;
    }

    static public String[] optionList(Flag fl){
        String[] preRand = new String[4];
        String[] postRand = new String[4];
        preRand[0] = fl.getCountry();
        List check;
        for (int i = 1; i<4;){
            Flag aflag = pickFlag();
            check = Arrays.asList(preRand);
            if (!check.contains(aflag.getCountry())){
                preRand[i]= aflag.getCountry();
                i++;
            }
        }


        for (int i = 0; i<4; i++){
            int randCon = rand.nextInt(4-i);
            String con = preRand[randCon];
            preRand[randCon]= preRand[3-i];
            preRand[3-i] = null;
            postRand[i] = con;
        }
        return postRand;
    }

}