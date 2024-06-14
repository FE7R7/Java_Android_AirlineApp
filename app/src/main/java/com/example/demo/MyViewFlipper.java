package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MyViewFlipper extends AppCompatActivity {

    private android.widget.ViewFlipper viewFlipper;
    private Button btu_next, btu_prev;
    private Button buttonToHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);


        viewFlipper = findViewById(R.id.view_flipper);
        btu_next = findViewById(R.id.btu_next);
        btu_prev = findViewById(R.id.btu_prev);
        buttonToHome = findViewById(R.id.b_flipperToMain);


        btu_next.setOnClickListener(v -> {
            viewFlipper.setInAnimation(MyViewFlipper.this,R.anim.slide_in_left);
            viewFlipper.setOutAnimation(MyViewFlipper.this,R.anim.slide_out_right);
            viewFlipper.showNext();
        });

        buttonToHome.setOnClickListener(view -> {

            Intent i = new Intent(MyViewFlipper.this, MainActivity_WelCome.class);

            startActivity(i);

        });

        btu_prev.setOnClickListener(v -> {
            viewFlipper.setInAnimation(MyViewFlipper.this,R.anim.slide_in_right);
            viewFlipper.setOutAnimation(MyViewFlipper.this,R.anim.slide_out_left);
            viewFlipper.showPrevious();
        });
    }

}