package com.spenterise.saytam;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.spenterise.saytam.Model.Food;
import com.squareup.picasso.Picasso;

public class fooddetial extends AppCompatActivity {


    TextView food_name,food_price,description;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    String foodId="";
    FirebaseDatabase database;
    DatabaseReference MenuItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetial);

        database=FirebaseDatabase.getInstance();
        MenuItems=database.getReference("MenuItems");

        numberButton=(ElegantNumberButton)findViewById(R.id.number_butten);
        btnCart=(FloatingActionButton)findViewById(R.id.btnCart);

        description=findViewById(R.id.food_description);
        food_name=findViewById(R.id.food_name);
        food_price=findViewById(R.id.food_price);
        food_image=findViewById(R.id.food_image);

        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleColor(R.style.ExpandeAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);

        if(getIntent()!=null)
            foodId=getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty())
        {
            getDetailFood(foodId);
        }

    }

    private void getDetailFood(String foodId) {
        MenuItems.child(foodId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Food food=dataSnapshot.getValue(Food.class);

                    Picasso.with(getBaseContext()).load(food.getImage())
                            .into(food_image);

                    collapsingToolbarLayout.setTitle(food.getName());
                    food_price.setText(food.getPrice());
                    food_name.setText(food.getName());
                    description.setText(food.getDescription());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

    }
}
