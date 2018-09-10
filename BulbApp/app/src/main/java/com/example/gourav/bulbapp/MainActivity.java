package com.example.gourav.bulbapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView ivOn,ivOff;
    Boolean isFaddeOut=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivOn=findViewById(R.id.ivOn);
        ivOff=findViewById(R.id.ivOff);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ivOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!isFaddeOut)
                        YoYo.with(Techniques.FadeOut).duration(100).playOn(ivOff);
                    else
                        YoYo.with(Techniques.FadeIn).duration(100).playOn(ivOff);
                    isFaddeOut=!isFaddeOut;

                }catch (Exception e){}
//                YoYo.with(Techniques.FadeOut).playOn(ivOff);
//                YoYo.with(Techniques.FadeIn).playOn(ivOn);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.iteam1:
                playMusic("ccc");

                Toast.makeText(this, "playing", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void playMusic (String view){

        int musicid=getResources().getIdentifier(view,"raw","com.example.gourav.bulbapp");
        MediaPlayer md=MediaPlayer.create(this,musicid);
        md.start();



    }
}
