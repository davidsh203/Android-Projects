package com.example.memorygame;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button moveToGameScreen;
    private EditText editTextPlayer1, editTextPlayer2;
    String p1, p2;
    //MediaPlayer welcomeSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveToGameScreen = findViewById(R.id.button);
        editTextPlayer1 = findViewById(R.id.editTextPlayer1);
        editTextPlayer2 = findViewById(R.id.editTextPlayer2);
        //welcomeSound = MediaPlayer.create(this, R.raw.welcome);
        //welcomeSound.start();
        moveToGameScreen.setOnClickListener(view -> {
            p1 = editTextPlayer1.getText().toString();
            p2 = editTextPlayer2.getText().toString();
            Intent intent = new Intent(MainActivity.this, GameScreen.class);
            intent.putExtra("p1", p1);
            intent.putExtra("p2", p2);
            startActivity(intent);
        });
    }
}





