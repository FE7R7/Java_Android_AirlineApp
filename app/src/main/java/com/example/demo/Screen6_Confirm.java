package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Screen6_Confirm extends AppCompatActivity {

    private Button b6;
    private Button b6_1;

    private TextView viewName;
    private TextView viewPassport;

    private String nameText;
    private String passportText;
    private String priceTotalS2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6_confirm);

        this.b6 = findViewById(R.id.b6);
        this.b6_1 = findViewById(R.id.b6_1);

        try {

            Bundle extras = getIntent().getExtras();

            priceTotalS2 = extras.getString("priceTotalToSend1");
            nameText = extras.getString("NameToSend");
            passportText = extras.getString("PassportToSend");

            viewName = findViewById(R.id.textViewDisplayed6);
            viewName.setText(nameText);

            viewPassport = findViewById(R.id.textViewDisplayed6_1);
            viewPassport.setText(passportText);


            ///////////// Print to the LogCat /////////////
            for (String key: extras.keySet())
            {
                Log.d ("From Screen 6: ", key + " is a key in the bundle");
            }
            ///////////////////////////////////////////////


        } catch (RuntimeException e) {

            e.printStackTrace();

        }



        this.b6_1.setOnClickListener(view -> {

            Intent i = new Intent(Screen6_Confirm.this, Screen7_CheckOut.class);

            i.putExtra("priceTotalToSend2", priceTotalS2);

            startActivity(i);

        });


        this.b6.setOnClickListener(view -> {

            Intent i = new Intent(Screen6_Confirm.this, Screen5_Fill_In.class);

            startActivity(i);

        });

    }
}