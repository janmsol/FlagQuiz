package com.example.janms.funwithflags;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Flag {
    private String country;
    private int flag;

    public Flag (String con, int fl){
        country = con;
        flag = fl;
        FlagRegister.getlist().add(this);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


    /**public Bitmap loadImage(String ref) {
        Bitmap bimg = null;
        try {
            bimg = BitmapFactory.decodeFile("C:\\Users\\janms\\AndroidStudioProjects\\FunWithFlags\\app\\src\\main\\java\\com\\example\\janms\\funwithflags\\assets");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimg;
    }**/
}
