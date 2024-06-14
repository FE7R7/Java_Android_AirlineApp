package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {

                    Intent i = new Intent(LoginScreen.this, MainActivity_WelCome.class);

                    startActivity(i);

                    Toast.makeText(LoginScreen.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(LoginScreen.this, "Login Failed!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}