package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Screen_10_YouTube extends AppCompatActivity {

    private Button btnWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen_10_you_tube);

        btnWeb = findViewById(R.id.b10);

        btnWeb.setOnClickListener(view -> {

            Intent i = new Intent(Screen_10_YouTube.this, Screen_11_WebView.class);

            startActivity(i);

        });

    }

}