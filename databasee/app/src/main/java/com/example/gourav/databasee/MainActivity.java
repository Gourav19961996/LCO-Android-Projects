package com.example.gourav.databasee;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    List<datamodel> list1;
    database db;
    Button bv1,bv2;
    Context context;
    EditText t5,t6,t7,t8;


  //   String TAG  ;
//    DatabaseReference myRef;
//    EditText text;
//    Button click;
//    ListView lvdata;
//    List<String> data;
   // List<datamodel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1=new ArrayList<>();
        rv1=findViewById(R.id.rv1);
        bv2=findViewById(R.id.bv2);
        db=new database(this);

        fetchdata();

        bv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(MainActivity.this);

                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);

                View vh=inflater.inflate(R.layout.dialog,null);
                dialog.setContentView(vh);
                dialog.show();

                t5=dialog.findViewById(R.id.t5);
                t6=dialog.findViewById(R.id.t6);
                t7=dialog.findViewById(R.id.t7);
                t8=dialog.findViewById(R.id.t8);
                bv1=dialog.findViewById(R.id.bv1);

                bv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // Toast.makeText(MainActivity.this, "clcick huaaaa", Toast.LENGTH_SHORT).show();
                      if(db.addcontact(new datamodel(t5.getText().toString(),t6.getText().toString(),t7.getText().toString(),t8.getText().toString()))){
                        //  Toast.makeText(MainActivity.this, "chalaaa", Toast.LENGTH_SHORT).show();
                          fetchdata();
                          dialog.dismiss();
                      }else{
                         // Toast.makeText(MainActivity.this, "nnnnnnnnnnn", Toast.LENGTH_SHORT).show();
                      }
                    }
                });



            }
        });
    }


    public void fetchdata(){
     database df = new database(MainActivity.this);
        if(!df.getContact().isEmpty()){
            list1=df.getContact();
          //  Toast.makeText(MainActivity.this, "fetch huaaa"+list1.get(0).getContact(), Toast.LENGTH_SHORT).show();


            adapter ad=new adapter(this,list1);
            rv1.setLayoutManager(new LinearLayoutManager(this));
            rv1.setAdapter(ad);

        }

    }
}
