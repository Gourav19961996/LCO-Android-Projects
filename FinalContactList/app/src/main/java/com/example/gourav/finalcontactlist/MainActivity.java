package com.example.gourav.finalcontactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    RecyclerView rv;
    String TAG="hhhh";
    List<String> list1;
    List<model> modelList;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv=findViewById(R.id.rv);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("contact list");
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               modelList=new ArrayList<>();
                modelList.clear();
                for (DataSnapshot data:dataSnapshot.getChildren()){
                    modelList.add(data.getValue(model.class));
                }
                list1=new ArrayList<>();

                for (model md:modelList){
                    list1.add(md.getName()+":"+md.getContact()+":"+md.getEmail());
                    Log.d(TAG, "onDataChangee: "+md.getName()+":"+md.getContact()+":"+md.getEmail());
                }

                adapter ad=new adapter(MainActivity.this,list1);
                LinearLayoutManager ab=new LinearLayoutManager(MainActivity.this);
                rv.setAdapter(ad);
                rv.setLayoutManager(ab);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
                Toast.makeText(this, "add your contact detail in dialog box", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }


}
