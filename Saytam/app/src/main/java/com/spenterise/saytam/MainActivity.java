package com.spenterise.saytam;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn,btnSignUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnSignIn= findViewById(R.id.btnSignIn);
         btnSignUP= findViewById(R.id.btnSignUP);

         btnSignUP.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent signUp=new Intent(MainActivity.this,SignUp.class);
                 startActivity(signUp);

             }
         });

         btnSignIn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent signIn=new Intent(MainActivity.this,SignIn.class);
                 startActivity(signIn);
             }
         });
    }

    private boolean checkInternetConnection() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        // ARE WE CONNECTED TO THE NET
        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {

            return true;

              } else {
            return false;


        }
    }
}
