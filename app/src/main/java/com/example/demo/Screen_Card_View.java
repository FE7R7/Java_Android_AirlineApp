package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Screen_Card_View extends AppCompatActivity {

    private CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_card_view);

        card1 = findViewById(R.id.card_view_1);

        card1.setOnClickListener(view -> {

            Intent i = new Intent(Screen_Card_View.this, Screen2_From_To.class);

            startActivity(i);

            overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);

        });
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }

}