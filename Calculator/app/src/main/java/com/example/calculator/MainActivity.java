package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewDisplay,textViewResult;
    private char opp;
    private int num1,num2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDisplay = findViewById(R.id.textViewDisplay);
        textViewResult = findViewById(R.id.textViewResult);

    }

    public void numberFunc(View view){
        textViewDisplay.append(((Button)view).getText().toString());
        textViewResult.append(((Button)view).getText().toString());
    }

    public void oppFunc(View view){
        String str = textViewResult.getText().toString();
        num1 = Integer.parseInt(str);
        opp = ((Button)view).getText().toString().charAt(0);
        textViewResult.append(((Button)view).getText().toString());
        textViewDisplay.setText("");
    }

    public void equalFunc(View view){
        String str = textViewDisplay.getText().toString();
        num2 = Integer.parseInt(str);
        textViewResult.append(((Button)view).getText().toString());
        double sum = 0;

        switch (opp){
            case '+':sum  =num1 + num2;break;
            case '-':sum  =num1 - num2;break;
            case '*':sum  =num1 * num2;break;
            case '/':sum  =num1 / num2;break;

        }
        textViewResult.append(sum+ "");
        textViewDisplay.setText("");
    }
    public void clearFunc(View view){
        textViewDisplay.setText("");
        textViewResult.setText("");
    }
}