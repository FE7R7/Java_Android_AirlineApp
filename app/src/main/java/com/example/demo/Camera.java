package com.example.demo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Camera extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 100;
    private ImageView imageViewCamera;
    private Button btu_take_photo;
    private Button buttonToHome;
    private ActivityResultLauncher<Intent> cameraLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageViewCamera = findViewById(R.id.imageView_Camera);
        btu_take_photo = findViewById(R.id.b_camera_snap);
        buttonToHome = findViewById(R.id.b_cameraToMain);

        btu_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check for camera permission
                if (ContextCompat.checkSelfPermission(Camera.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Request the permission
                    ActivityCompat.requestPermissions(Camera.this,
                            new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
                } else {
                    // Permission already granted, launch camera
                    takePhoto();
                }
            }
        });

        this.buttonToHome.setOnClickListener(view -> {

            Intent i = new Intent(Camera.this, MainActivity_WelCome.class);

            startActivity(i);

        });

        // Initialize the cameraLauncher
        cameraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            // Photo capture was successful
                            Bundle extras = result.getData().getExtras();
                            Bitmap imageBitmap = (Bitmap) extras.get("data");
                            imageViewCamera.setImageBitmap(imageBitmap);
                        }
                    }
                });
    }

    // Method to launch the camera app
    private void takePhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            cameraLauncher.launch(takePictureIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, launch camera
                takePhoto();
            } else {
                // Permission denied, show a message or handle it gracefully
                // You can display a message to the user or disable the camera functionality.
            }
        }
    }
}
