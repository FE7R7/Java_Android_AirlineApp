package com.example.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Screen_Email_SMS extends AppCompatActivity {

    private ImageView id_email,id_sms;
    private Button b_emailToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_email_sms);

        id_email = findViewById(R.id.imageEmail);
        id_sms = findViewById(R.id.imageSms);
        this.b_emailToMain = findViewById(R.id.b_emailToMain);

        id_email.setOnClickListener(v -> {
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{"a00289109@student.tus.ie"});
            email.putExtra(Intent.EXTRA_SUBJECT, "Hello from my App");
            email.putExtra(Intent.EXTRA_TEXT, "Deus Abencoa!!!!!!!");
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "Send Mail Using :"));

        });

        id_sms.setOnClickListener(v -> {
            Uri uri = Uri.parse("smsto:77777777777");
            Intent msg = new Intent(Intent.ACTION_SENDTO, uri);
            msg.putExtra("sms_body", "The SMS text");
            startActivity(Intent.createChooser(msg, "Send sms Using :"));

        });

        b_emailToMain.setOnClickListener(view -> {

            Intent i = new Intent(Screen_Email_SMS.this, MainActivity_WelCome.class);

            startActivity(i);

        });
    }
}