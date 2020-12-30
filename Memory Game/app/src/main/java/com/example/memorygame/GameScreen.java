package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class GameScreen extends AppCompatActivity {
    private TextView textViewP1, textViewP2;
    private ImageView imageView11, imageView12, imageView13, imageView14,
            imageView21, imageView22, imageView23, imageView24,
            imageView31, imageView32, imageView33, imageView34;

    //array for the images
    private Integer[] cardArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};

    //actual images
    private int image101, image102, image103, image104, image105, image106, image201, image202, image203, image204, image205, image206;

    private int firstCard, secondCard;
    private int clickedFirst, clickedSecond;
    private int cardNumber = 1;
    private int turn = 1;
    private int firstPlayerPoints = 0, secondPlayerPoints = 0;

    private String nameP1, nameP2, winName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        textViewP1 = findViewById(R.id.textViewP1);
        textViewP2 = findViewById(R.id.textViewP2);

        imageView11 = findViewById(R.id.iv_11);
        imageView12 = findViewById(R.id.iv_12);
        imageView13 = findViewById(R.id.iv_13);
        imageView14 = findViewById(R.id.iv_14);
        imageView21 = findViewById(R.id.iv_21);
        imageView22 = findViewById(R.id.iv_22);
        imageView23 = findViewById(R.id.iv_23);
        imageView24 = findViewById(R.id.iv_24);
        imageView31 = findViewById(R.id.iv_31);
        imageView32 = findViewById(R.id.iv_32);
        imageView33 = findViewById(R.id.iv_33);
        imageView34 = findViewById(R.id.iv_34);

        imageView11.setTag("0");
        imageView12.setTag("1");
        imageView13.setTag("2");
        imageView14.setTag("3");
        imageView21.setTag("4");
        imageView22.setTag("5");
        imageView23.setTag("6");
        imageView24.setTag("7");
        imageView31.setTag("8");
        imageView32.setTag("9");
        imageView33.setTag("10");
        imageView34.setTag("11");

        frontOfCardResources();
        Collections.shuffle(Arrays.asList(cardArray));

        imageView11.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView11, theCard);
        });

        imageView12.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView12, theCard);
        });

        imageView13.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView13, theCard);
        });

        imageView14.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView14, theCard);
        });

        imageView21.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView21, theCard);
        });

        imageView22.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView22, theCard);
        });

        imageView23.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView23, theCard);
        });

        imageView24.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView24, theCard);
        });

        imageView31.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView31, theCard);
        });

        imageView32.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView32, theCard);
        });

        imageView33.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView33, theCard);
        });

        imageView34.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(imageView34, theCard);
        });


        getNames();

    }

    private void getNames() {
        Intent intent = getIntent();
        nameP1 = intent.getStringExtra("p1");
        nameP2 = intent.getStringExtra("p2");
        textViewP1.setText(nameP1 + ": 0");
        textViewP2.setText(nameP2 + ": 0");
    }

    private void doStuff(ImageView imageView, int card) {
//        set the correct image to the imageView
        if (cardArray[card] == 101) {
            imageView.setImageResource(image101);
        } else if (cardArray[card] == 102) {
            imageView.setImageResource(image102);
        } else if (cardArray[card] == 103) {
            imageView.setImageResource(image103);
        } else if (cardArray[card] == 104) {
            imageView.setImageResource(image104);
        } else if (cardArray[card] == 105) {
            imageView.setImageResource(image105);
        } else if (cardArray[card] == 106) {
            imageView.setImageResource(image106);
        } else if (cardArray[card] == 201) {
            imageView.setImageResource(image201);
        } else if (cardArray[card] == 202) {
            imageView.setImageResource(image202);
        } else if (cardArray[card] == 203) {
            imageView.setImageResource(image203);
        } else if (cardArray[card] == 204) {
            imageView.setImageResource(image204);
        } else if (cardArray[card] == 205) {
            imageView.setImageResource(image205);
        } else if (cardArray[card] == 206) {
            imageView.setImageResource(image206);
        }

        // check which image is selected and save it to the temporary variable
        if (cardNumber == 1) {
            firstCard = cardArray[card];
            if (firstCard > 200) {
                firstCard -= 100;
            }
            cardNumber = 2;
            clickedFirst = card;
            imageView.setEnabled(false); //that the clickListener dont working

        } else if (cardNumber == 2) {
            secondCard = cardArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            imageView11.setEnabled(false);
            imageView12.setEnabled(false);
            imageView13.setEnabled(false);
            imageView14.setEnabled(false);
            imageView21.setEnabled(false);
            imageView22.setEnabled(false);
            imageView23.setEnabled(false);
            imageView24.setEnabled(false);
            imageView31.setEnabled(false);
            imageView32.setEnabled(false);
            imageView33.setEnabled(false);
            imageView34.setEnabled(false);

            Handler handler = new Handler(); //is deprecated
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);

        }


    }

    private void calculate() {
        //if image are equal, remove them and add points to the user
        if (firstCard == secondCard) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
            if (clickedFirst == 0) {
                imageView11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                imageView12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                imageView13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                imageView14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                imageView21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                imageView22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                imageView23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                imageView24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                imageView31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                imageView32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                imageView33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                imageView34.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                imageView11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                imageView12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                imageView13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                imageView14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                imageView21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                imageView22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                imageView23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                imageView24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                imageView31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                imageView32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                imageView33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                imageView34.setVisibility(View.INVISIBLE);
            }

            //add points to the player
            if (turn == 1) {
                firstPlayerPoints++;
                textViewP1.setText(nameP1 + ": " + firstPlayerPoints);
            } else if (turn == 2) {
                secondPlayerPoints++;
                textViewP2.setText(nameP2 + ": " + secondPlayerPoints);
            }
        } else {
            imageView11.setImageResource(R.drawable.q);
            imageView12.setImageResource(R.drawable.q);
            imageView13.setImageResource(R.drawable.q);
            imageView14.setImageResource(R.drawable.q);
            imageView21.setImageResource(R.drawable.q);
            imageView22.setImageResource(R.drawable.q);
            imageView23.setImageResource(R.drawable.q);
            imageView24.setImageResource(R.drawable.q);
            imageView31.setImageResource(R.drawable.q);
            imageView32.setImageResource(R.drawable.q);
            imageView33.setImageResource(R.drawable.q);
            imageView34.setImageResource(R.drawable.q);

            //change the player turn
            if (turn == 1) {
                turn = 2;
                textViewP2.setTextColor(Color.RED);
                textViewP1.setTextColor(Color.BLUE);
            } else if (turn == 2) {
                turn = 1;
                textViewP1.setTextColor(Color.RED);
                textViewP2.setTextColor(Color.BLUE);
            }
        }
        imageView11.setEnabled(true);
        imageView12.setEnabled(true);
        imageView13.setEnabled(true);
        imageView14.setEnabled(true);
        imageView21.setEnabled(true);
        imageView22.setEnabled(true);
        imageView23.setEnabled(true);
        imageView24.setEnabled(true);
        imageView31.setEnabled(true);
        imageView32.setEnabled(true);
        imageView33.setEnabled(true);
        imageView34.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    private void checkEnd() {
        if (imageView11.getVisibility() == View.INVISIBLE &&
                imageView12.getVisibility() == View.INVISIBLE &&
                imageView13.getVisibility() == View.INVISIBLE &&
                imageView14.getVisibility() == View.INVISIBLE &&
                imageView21.getVisibility() == View.INVISIBLE &&
                imageView22.getVisibility() == View.INVISIBLE &&
                imageView23.getVisibility() == View.INVISIBLE &&
                imageView24.getVisibility() == View.INVISIBLE &&
                imageView31.getVisibility() == View.INVISIBLE &&
                imageView32.getVisibility() == View.INVISIBLE &&
                imageView33.getVisibility() == View.INVISIBLE &&
                imageView34.getVisibility() == View.INVISIBLE) {
            boolean win = (firstPlayerPoints > secondPlayerPoints) ? true : false;
            if (win) winName = nameP1;
            else winName = nameP2;
            if (firstPlayerPoints == secondPlayerPoints) winName = "Draw";
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameScreen.this);
            alertDialogBuilder.setMessage(winName + " is winner" + "\n" + textViewP1.getText().toString() + " points\n" + textViewP2.getText().toString() + " points")
                    .setCancelable(false)
                    .setPositiveButton("New Game?", (dialogInterface, i) -> {
                        Intent intent = new Intent(getApplicationContext(), GameScreen.class);
                        intent.putExtra("p1", nameP1);
                        intent.putExtra("p2", nameP2);
                        startActivity(intent);
                        finish();
                    }).setNegativeButton("Exit", (dialogInterface, i) -> finish());
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void frontOfCardResources() {
        image101 = R.drawable.one;
        image102 = R.drawable.two;
        image103 = R.drawable.three;
        image104 = R.drawable.four;
        image105 = R.drawable.five;
        image106 = R.drawable.six;
        image201 = R.drawable.one_copy;
        image202 = R.drawable.two_copy;
        image203 = R.drawable.three_copy;
        image204 = R.drawable.four_copy;
        image205 = R.drawable.five_copy;
        image206 = R.drawable.six_copy;
    }
}