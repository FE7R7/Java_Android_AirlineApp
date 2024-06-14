package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Screen4_Class extends AppCompatActivity {

    private int priceClass;
    private int priceTotal;
    private String priceFromTo3;
    private String priceTotalS;


    private RadioGroup radioGroup4;
    private RadioButton choiceSelected;
    private Button b4;
    private Button b4_1;
    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4_class);

        this.radioGroup4 = findViewById(R.id.radioGroup4);
        this.b4 = findViewById(R.id.b4);
        this.b4_1 = findViewById(R.id.b4_1);


        b4_1.setOnClickListener(view -> {

            try{

                int selectedId = this.radioGroup4.getCheckedRadioButtonId();
                choiceSelected = findViewById(selectedId);
                text = String.valueOf(choiceSelected.getText());

                Bundle extras = getIntent().getExtras();

                priceFromTo3 = extras.getString("priceFromTo2");

                int priceFromTo3Num = Integer.parseInt(priceFromTo3);

                priceTotal = priceFromTo3Num + priceClass;

                priceTotalS = String.valueOf(priceTotal);



                switch (text) {

                    case "Business Class":

                        priceClass += 70;
                        break;

                    case "First Class":

                        priceClass += 40;
                        break;

                    case "Economic Class":

                        priceClass += 0;
                        break;
                }

            }catch (RuntimeException e){

                e.printStackTrace();

            }


            Intent i = new Intent(Screen4_Class.this, Screen5_Fill_In.class);

            i.putExtra("priceTotalToSend", priceTotalS);

            startActivity(i);

            Toast.makeText(Screen4_Class.this, text, Toast.LENGTH_SHORT).show();

        });

        b4.setOnClickListener(view -> {

            Intent i = new Intent(Screen4_Class.this, Screen2_From_To.class);

            startActivity(i);

        });

    }

}