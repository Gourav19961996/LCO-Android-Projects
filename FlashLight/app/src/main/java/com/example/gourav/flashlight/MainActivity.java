package com.example.gourav.flashlight;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch sw;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw=findViewById(R.id.sw);

        final CameraManager cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);

        sw.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                try {
                    String camraID = cameraManager.getCameraIdList()[0];
                    if (sw.isChecked()){
                        cameraManager.setTorchMode(camraID,true);
                    }else {
                        cameraManager.setTorchMode(camraID,false);
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
