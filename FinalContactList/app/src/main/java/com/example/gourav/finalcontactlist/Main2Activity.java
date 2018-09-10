package com.example.gourav.finalcontactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    EditText etName,etContact,etEmail;
    Button bvAdd;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName=findViewById(R.id.etName);
        etContact=findViewById(R.id.etContact);
        etEmail=findViewById(R.id.etEmail);
        bvAdd=findViewById(R.id.bvAdd);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
         myRef = database.getReference("contact list");


        bvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  myRef.setValue("Hello, World!");
                String id=myRef.push().getKey();
                myRef.child(id).setValue(new model(id,etName.getText().toString(),etContact.getText().toString(),etEmail.getText().toString()));
                Toast.makeText(Main2Activity.this, "Saved to firebase", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
