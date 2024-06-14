package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Screen2_From_To extends AppCompatActivity {

    private int priceFromTo = 0;
    private ImageView img2;

    private RadioGroup radioGroup2;
    private RadioGroup radioGroup2_1;
    private RadioGroup radioGroup2_2;

    private RadioButton selected2;
    private RadioButton selected2_1;
    private RadioButton selected2_2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2_from_to);



        this.radioGroup2 = findViewById(R.id.radioGroup2);
        this.radioGroup2_1 = findViewById(R.id.radioGroup2_1);
        this.radioGroup2_2 = findViewById(R.id.radioGroup2_2);
        this.img2 = findViewById(R.id.img2_1);



        img2.setOnClickListener(view -> {


            try{

                int IdSelected2 = radioGroup2.getCheckedRadioButtonId();
                selected2 = findViewById(IdSelected2);
                String text2 = String.valueOf(selected2.getText());

                Toast.makeText(Screen2_From_To.this, text2, Toast.LENGTH_SHORT).show();

                int IdSelected2_1 = radioGroup2_1.getCheckedRadioButtonId();
                selected2_1 = findViewById(IdSelected2_1);
                String text2_1 = String.valueOf(selected2_1.getText());

                Toast.makeText(Screen2_From_To.this, text2_1, Toast.LENGTH_SHORT).show();

                int IdSelected2_2 = radioGroup2_2.getCheckedRadioButtonId();
                selected2_2 = findViewById(IdSelected2_2);
                String text2_2 = String.valueOf(selected2_2.getText());

                Toast.makeText(Screen2_From_To.this, text2_2, Toast.LENGTH_SHORT).show();



                if(text2.equals("Dublin") && text2_1.equals("Netherlands") ){

                    priceFromTo += 50;

                }
                else if (text2.equals("Dublin") && text2_1.equals("Switzerland") ){
                    priceFromTo += 50;

                }

                if(text2.equals("Italy") && text2_1.equals("Netherlands") ){

                    priceFromTo += 35;

                }
                else if (text2.equals("Italy") && text2_1.equals("Switzerland") ) {

                    priceFromTo += 25;

                }




                if(text2.equals("Dublin") && text2_1.equals("Netherlands") ){

                    priceFromTo += 100;

                }
                else if (text2.equals("Dublin") && text2_1.equals("Switzerland") ){

                    priceFromTo += 100;

                }



                if(text2.equals("Italy") && text2_1.equals("Netherlands") ){

                    priceFromTo += 70;

                }
                else if (text2.equals("Italy") && text2_1.equals("Switzerland") ) {

                    priceFromTo += 50;

                }



                if (text2_2.equals("Return-Trip")) {

                    priceFromTo += priceFromTo/2 ;

                }
                else if( text2_2.equals("One-Way")) {

                    priceFromTo += 0;

                }


            }catch (RuntimeException e){

                e.printStackTrace();
            }


            Intent i = new Intent(Screen2_From_To.this, Screen3_Processing.class);

            i.putExtra("priceFromTo", String.valueOf(priceFromTo));

            startActivity(i);

        });

    }

}