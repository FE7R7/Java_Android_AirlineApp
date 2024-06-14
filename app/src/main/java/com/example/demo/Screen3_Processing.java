package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import java.util.Timer;
import java.util.TimerTask;

public class Screen3_Processing extends AppCompatActivity {

    private int counter = 0;
    private ProgressBar progressBar;
    private String priceFromTo2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3_processing);


        progressBar = findViewById(R.id.progressBar3);
        Timer t  = new Timer();


        TimerTask tt = new TimerTask() {
            @Override
            public void run() {

                try{

                    Bundle extras = getIntent().getExtras();

                    priceFromTo2 = extras.getString("priceFromTo");

                }catch (RuntimeException e){

                    e.printStackTrace();
                }


                counter = counter + 5;

                progressBar.setProgress(counter);

                if(counter == 100) {

                    t.cancel();

                    Intent i = new Intent(Screen3_Processing.this, Screen4_Class.class);

                    i.putExtra("priceFromTo2", priceFromTo2);

                    startActivity(i);

                }
            }
        };

        t.schedule(tt,0,100);

    }
}

