package com.example.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Screen7_CheckOut extends AppCompatActivity {

    private TextView priceToDisplay;
    private String priceTotalS3;

    private Button b7;
    private Button b7_1;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7_check_out);


        this.b7 = findViewById(R.id.b7);
        this.b7_1 = findViewById(R.id.b7_1);


        try {

            Bundle extras = getIntent().getExtras();

            priceTotalS3 = extras.getString("priceTotalToSend2");

            priceToDisplay = findViewById(R.id.etx4s7);

            priceToDisplay.setText(" € " + priceTotalS3 + ",00");

        } catch (RuntimeException e) {

            e.printStackTrace();

        }


        this.b7_1.setOnClickListener(view -> {


            Intent i = new Intent(Screen7_CheckOut.this, Screen8_Payment_Confirmation.class);

            startActivity(i);

        });


        this.b7.setOnClickListener( view -> {

            Intent i = new Intent(Screen7_CheckOut.this, Screen6_Confirm.class);

            startActivity(i);

        });

    }

}