package com.example.searchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnSearch;
    private EditText search;
    private RadioButton rb_google, rb_yahoo, rb_bing, rb_duckduckgo;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.editTxt_search);
        rb_google = findViewById(R.id.rb_google);
        rb_bing = findViewById(R.id.rb_bing);
        rb_duckduckgo = findViewById(R.id.rb_duckduckgo);
        rb_yahoo = findViewById(R.id.rb_yahoo);


        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(v -> {
        String searchString = search.getText().toString();
            if (rb_google.isChecked()) {
                url= String.format("http://www.google.com/search?q=%s",searchString);
            } else if (rb_bing.isChecked()) {
                url= String.format("https://www.bing.com/search?q=%s",searchString);
            } else if (rb_duckduckgo.isChecked()) {
                url= String.format("https://duckduckgo.com/?q=%s",searchString);

            } else {
                url= String.format("https://search.yahoo.com/search?p=%s",searchString);
            }
            Intent intent = new Intent(MainActivity.this, SearchWebActivity.class);
            intent.putExtra("url",url);
            startActivity(intent);
        });
    }
}
