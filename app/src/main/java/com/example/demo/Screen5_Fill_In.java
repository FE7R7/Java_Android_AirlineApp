package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Screen5_Fill_In extends AppCompatActivity {

    private TextView etx5;
    private TextView etx5_1;


    private Button b5;
    private Button b5_1;


    private String priceTotalS1;
    private String nameText;
    private String passportText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5_fill_in);


        this.b5 = findViewById(R.id.b5);
        this.b5_1 = findViewById(R.id.b5_1);


        this.b5_1.setOnClickListener(view -> {

            try{

                etx5 = findViewById(R.id.etx1S5);
                etx5_1 = findViewById(R.id.etx2S5);

                nameText = String.valueOf(etx5.getText());
                passportText = String.valueOf(etx5_1.getText());

                Toast.makeText(this, nameText, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, passportText, Toast.LENGTH_SHORT).show();

                Bundle extras = getIntent().getExtras();

                priceTotalS1 = extras.getString("priceTotalToSend");

            }catch (RuntimeException e){

                e.printStackTrace();
            }


            Intent i = new Intent(Screen5_Fill_In.this, Screen6_Confirm.class);

            i.putExtra("NameToSend", nameText);
            i.putExtra("PassportToSend", passportText);
            i.putExtra("priceTotalToSend1", priceTotalS1);

            startActivity(i);

        });

        this.b5.setOnClickListener(view -> {

            Intent i = new Intent(Screen5_Fill_In.this, Screen4_Class.class);

            startActivity(i);

        });

    }

}