package com.example.halki.testnumbersapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;


public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    public int upLimit;
    private int lowLimit;
    private int guessNumber;
    private int turns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    //Starts game with the entered integer. Returns and toasts if the field is empty.
    public void start(View view){
        hideKeyboard(this);
        EditText editText = findViewById(R.id.editText);
        if(isEmpty(editText)){
            Toast.makeText(this, "Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }
        upLimit = Integer.parseInt(editText.getText().toString());
        lowLimit = 0;
        System.out.println("The upper limit is: "+upLimit);
        setContentView(R.layout.activity_guess);
        turns = 0;
        guess();
    }

    //Quickly starts game with the upper limit being 1,000.
    public void startWithThou(View view){
        upLimit = 1000;
        lowLimit = 0;
        System.out.println("The upper limit is: "+upLimit);
        setContentView(R.layout.activity_guess);
        turns = 0;
        guess();
    }

    public void back(View view){
        setContentView(R.layout.activity_main);
    }

    void guess(){
        int prevNumber = guessNumber;
        if(turns >= 10){
            setContentView(R.layout.activity_win);
            return;
        }
        guessNumber = rand.nextInt(upLimit-lowLimit)+lowLimit;
        if((upLimit-lowLimit)==1){
            Toast.makeText(this, "Is this your number?", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(guessNumber == prevNumber){
            guess();
        }
        //guessNumber = (upLimit+lowLimit)/2;
        display();
        System.out.println("Upper bound is: "+upLimit+"  Lower bound is: "+lowLimit);
    }

    void display(){
        TextView viewStr = findViewById(R.id.textView2);
        viewStr.setText(""+guessNumber);
        System.out.println("Currently displaying: ");
    }

    public void lower(View view){
        turns++;
        if(guessNumber == 0){
            guessNumber = 0;
            return;
        }
        upLimit = guessNumber;
        guess();
    }
    public void higher(View view){
        turns++;
        lowLimit = guessNumber;
        guess();
    }
    public void correct(View view){
        Toast.makeText(this, "I win!", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
