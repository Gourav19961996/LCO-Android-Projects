package com.abc.recorder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    MediaRecorder mediaRecorder;
    final int RECORD_AUDIO = 0;
    MediaPlayer mp;
    String path;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1000){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(!checkPermission()){
                String per[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO
                };

                requestPermissions(per, 1000);
            }
        }


        final File dir = new File(Environment.getExternalStorageDirectory(), "/Abhi/");
        if((!dir.exists())) {
            dir.mkdir();
        }

        findViewById(R.id.rec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play("but");
                Log.d("aaa","aaaaaa");
                Toast.makeText(MainActivity.this, "Started",Toast.LENGTH_SHORT).show();
                path = dir.getAbsolutePath()+"/"+ UUID.randomUUID()+".mp3";
                RecorderSetup(path);
                try {
                    mediaRecorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaRecorder.start();


            }
        });

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play("but");
                mp = new MediaPlayer();
                Toast.makeText(MainActivity.this, "Playing", Toast.LENGTH_SHORT).show();
                try
                {
                    mp.setDataSource(path);
                    mp.prepare();
                    mp.start();
                }catch (IOException e){
                    e.printStackTrace();
                }


            }
        });

        findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play("but");
                Toast.makeText(MainActivity.this, "Stopped", Toast.LENGTH_SHORT).show();
                if(mediaRecorder != null){
                    mediaRecorder.stop();
                    mediaRecorder.release();
                }
            }
        });


    }



    public void RecorderSetup(String p){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(p);
    }
    public boolean checkPermission(){
        boolean is=false;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                is = true;
            } else {
                is = false;
            }
            if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED){
                is = true;
            } else {
                is = false;
            }
        }
        return is;
    }
    public void play(String view){
        int i=getResources().getIdentifier(view,"raw","com.abc.recorder");
        MediaPlayer sd=MediaPlayer.create(this,i);
        sd.start();
    }
}