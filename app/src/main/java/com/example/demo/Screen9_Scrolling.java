package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Screen9_Scrolling extends AppCompatActivity {
    private Button btnYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen9_scrolling);

        btnYouTube = findViewById(R.id.b9);

        btnYouTube.setOnClickListener(view -> {

            Intent i = new Intent(Screen9_Scrolling.this, Screen_10_YouTube.class);

            startActivity(i);

        });

    }

}

