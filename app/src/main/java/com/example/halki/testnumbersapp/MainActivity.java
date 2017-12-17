package com.example.halki.testnumbersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    private int upLimit;
    private int lowLimit;
    private int guessNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start(500);
    }
    void start(int limit){
        lowLimit = 0;
        upLimit = limit;
        guess();
    }
    void guess(){
        guessNumber = rand.nextInt(upLimit+1-lowLimit)+lowLimit;

    }
    void lower(){
        upLimit = guessNumber;
        guess();
    }
    void higher(){
        lowLimit = guessNumber;
        guess();
    }
    void correct(){

    }
}
