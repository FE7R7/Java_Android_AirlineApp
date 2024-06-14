package com.example.demo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Screen_12_SharedPreferences extends AppCompatActivity {

    private Button btu_store, btu_show;
    private EditText etx;
    private SharedPreferences sp_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_12_sharedpreferences);

        etx = findViewById(R.id.etx);
        btu_store = findViewById(R.id.btu_store);
        btu_show = findViewById(R.id.btu_show);

        btu_store.setOnClickListener(view -> {

            sp_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp_database.edit();
            String txt = etx.getText().toString();
            editor.putString("key_saved_text", txt);
            editor.apply();
            Toast.makeText(Screen_12_SharedPreferences.this, "Data Saved!", Toast.LENGTH_SHORT).show();

        });

        btu_show.setOnClickListener(view -> {

            sp_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
            String name = sp_database.getString("key_saved_text", null);
            Toast.makeText(Screen_12_SharedPreferences.this, name, Toast.LENGTH_SHORT).show();

        });

    }


}