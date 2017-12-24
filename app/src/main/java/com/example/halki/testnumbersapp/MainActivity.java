package com.example.halki.testnumbersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;


public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    public int upLimit;
    private int lowLimit;
    private int guessNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        EditText editText = findViewById(R.id.editText);
        upLimit = Integer.parseInt(editText.getText().toString());
        lowLimit = 0;
        System.out.println("The upper limit is: "+upLimit);
        setContentView(R.layout.activity_guess);
    }

    public void back(View view){
        setContentView(R.layout.activity_main);
    }

    void guess(){
        guessNumber = rand.nextInt(upLimit+1-lowLimit)+lowLimit;

    }

    void display(){

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
