package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import java.util.Timer;
import java.util.TimerTask;

public class Screen8_Payment_Confirmation extends AppCompatActivity {

    private int counter = 0;
    private ProgressBar bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen8_payment_confirmation);

        bar = findViewById(R.id.progressBar8);

        Timer t  = new Timer();

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter = counter + 5;
                bar.setProgress(counter);

                if(counter == 100) {
                    t.cancel();
                    Intent i = new Intent(Screen8_Payment_Confirmation.this, Screen9_Scrolling.class);

                    startActivity(i);
                }
            }
        };
        t.schedule(tt,0,100);

    }

}