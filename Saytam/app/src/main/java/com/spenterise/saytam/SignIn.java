package com.spenterise.saytam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.spenterise.saytam.Common.Common;
import com.spenterise.saytam.Model.User;

public class SignIn extends AppCompatActivity {

    EditText editPhone,editPassword;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

           editPhone=(MaterialEditText)findViewById(R.id.editPhone);
           editPassword=(MaterialEditText)findViewById(R.id.editPassword);
           btnSignIn=findViewById(R.id.btnSignIn);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please wating.....");
                mDialog.show();


               table_user.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                      if(dataSnapshot.child(editPhone.getText().toString()).exists()) {

                          mDialog.dismiss();
                          User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                          assert user != null;
                          if (user.getPassword().equals(editPassword.getText().toString())) {
                              {
                                  Intent homeIntent=new Intent(SignIn.this,Home.class);
                                  Common.currentUser=user;
                                  startActivity(homeIntent);
                                  finish();
                              }

                          } else {
                              Toast.makeText(SignIn.this, "Password is Wrong !!!", Toast.LENGTH_SHORT).show();
                          }
                      } else
                          {
                              mDialog.dismiss();
                              Toast.makeText(SignIn.this,"User not exist",Toast.LENGTH_SHORT).show();
                          }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
            }
        });
    }
}
