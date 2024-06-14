package com.example.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity_WelCome extends AppCompatActivity {

    private Button btnMain;
    private Button btn_phone;
    private Button btn_maps;
    private Button btn_browser;
    private Button btn_airplane;
    private Button btn_calendar;
    private Button btn_camera;
    private Toolbar toolbar;



    @SuppressLint({"QueryPermissionsNeeded", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_welcome);


        // --------- Buttons & ToolBar ---------- //

        btnMain = findViewById(R.id.bMain);
        btn_phone = findViewById(R.id.bMain_1_Phone);
        btn_maps = findViewById(R.id.bMain_2_Maps);
        btn_browser = findViewById(R.id.bMain_3_Browser);
        btn_airplane = findViewById(R.id.bMain_4_Airplane);
        btn_calendar= findViewById(R.id.bMain_5_Calendar);
        btn_camera= findViewById(R.id.bMain_6_Camera);
        toolbar = findViewById(R.id.toolbar);


        btnMain.setOnClickListener(view -> {

            Intent i = new Intent(MainActivity_WelCome.this, Screen2_From_To.class);

            startActivity(i);

        });

        btn_phone.setOnClickListener(view -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + "4747474747"));

            startActivity(i);

        });

        btn_maps.setOnClickListener(view -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:48.8584,2.2945"));

            startActivity(i);

        });

        btn_browser.setOnClickListener(view -> {

            Uri uri = Uri.parse("https://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            startActivity(intent);

        });

        btn_airplane.setOnClickListener(view -> {

            MediaPlayer mp = MediaPlayer.create(MainActivity_WelCome.this, R.raw.airplane);

            mp.start();
        });

        btn_calendar.setOnClickListener(view -> {

            Intent i = new Intent(MainActivity_WelCome.this, Calendar.class);

            startActivity(i);

            overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);

        });

        btn_camera.setOnClickListener(view -> {

            Intent i = new Intent(MainActivity_WelCome.this, Camera.class);

            startActivity(i);

            overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);

        });

        // --------- Toolbar ---------- //

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Fly Airlines");

        int d = R.drawable.hamburger;
        int whiteColorValue = Color.WHITE;

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        toolbar.setOverflowIcon(getDrawable(d));
        toolbar.getOverflowIcon().setTint(whiteColorValue);
    }

    // --------- Menu ---------- //

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.scroll_option) {
            Intent i = new Intent(MainActivity_WelCome.this, Screen9_Scrolling.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.youtube_option) {

            Intent i = new Intent(MainActivity_WelCome.this, Screen_10_YouTube.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.share_option) {

            Intent i = new Intent(MainActivity_WelCome.this, Screen_12_SharedPreferences.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.cardView_option) {

            Intent i = new Intent(MainActivity_WelCome.this, Screen_Card_View.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.emailSms_option) {

            Intent i = new Intent(MainActivity_WelCome.this, Screen_Email_SMS.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.travelList_option) {

            Intent i = new Intent(MainActivity_WelCome.this, TravelList.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.travelImageList_option) {

            Intent i = new Intent(MainActivity_WelCome.this, TravelImageList.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.travelViewFlipper_option) {

            Intent i = new Intent(MainActivity_WelCome.this, MyViewFlipper.class);

            startActivity(i);

            return true;
        }

        if (id == R.id.calculator_option) {

            Intent i = new Intent(MainActivity_WelCome.this, Calculator.class);

            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}