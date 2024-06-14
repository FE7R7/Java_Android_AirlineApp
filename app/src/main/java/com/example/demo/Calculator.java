package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calculator extends AppCompatActivity {

    public static final String CALCULATOR_PACKAGE = "com.android.calculator2";
    public static final String CALCULATOR_CLASS = "com.android.calculator2.Calculator";

    private Button showCalculator;
    private Button b_calc_main;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        b_calc_main = findViewById(R.id.b_calculator_home);

        showCalculator = (Button) findViewById(R.id.showCalculatorButton);

        showCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setComponent(new ComponentName(
                        CALCULATOR_PACKAGE,
                        CALCULATOR_CLASS));

                Calculator.this.startActivity(intent);


            }
        });

        this.b_calc_main.setOnClickListener( view -> {

            Intent i = new Intent(Calculator.this, MainActivity_WelCome.class);

            startActivity(i);

        });
    }

}