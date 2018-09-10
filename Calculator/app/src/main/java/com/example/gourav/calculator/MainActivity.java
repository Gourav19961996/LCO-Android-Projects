package com.example.gourav.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double first,second,result;
    boolean addition=false,
            subtraction=false,
            multipaction=false,
            division=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nine=findViewById(R.id.nine);
        Button eight=findViewById(R.id.eight);
        Button seven=findViewById(R.id.seven);
        Button six=findViewById(R.id.six);
        Button five=findViewById(R.id.five);
        Button four=findViewById(R.id.four);
        Button three=findViewById(R.id.three);
        Button two=findViewById(R.id.two);
        Button one=findViewById(R.id.one);
        Button dot=findViewById(R.id.dot);
        Button zero=findViewById(R.id.zero);
        Button equal=findViewById(R.id.equal);
        Button delet=findViewById(R.id.delet);
        Button add=findViewById(R.id.add);
        Button sub=findViewById(R.id.sub);
        Button mul=findViewById(R.id.mul);
        Button div=findViewById(R.id.div);
        final TextView t1=findViewById(R.id.tv);
        t1.setText("");

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("9");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("8");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("7");


            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("6");

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("5");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("4");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("3");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("2");

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("1");

            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append(".");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.append("0");

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    second=Double.valueOf(t1.getText().toString());


                    if (addition){
                        result=first+second;
                        t1.setText("" + result);
                    }

                    else if (subtraction)

                    {
                        result = first - second;
                        t1.setText("" + result);


                    }else if (multipaction){
                        result = first * second;
                        t1.setText("" + result);


                    }else if (division) {
                        result = first / second;
                        t1.setText("" + result);
                    }}catch (Exception e){}


            }
        });

        delet.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                try{
                    String get = t1.getText().toString();
                    t1.setText(get.substring(0, get.length() - 1));}
                catch (Exception e){
                }

            }

        });
        delet.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                t1.setText(null);
                return false;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    first = Double.valueOf(t1.getText().toString());
                    t1.setText(null);
                    addition = true;
                    subtraction = false;
                    multipaction = false;
                    division = false;
                }catch (Exception e){}


            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    first = Double.valueOf(t1.getText().toString());
                    t1.setText(null);
                    addition = true;
                    subtraction = true;
                    multipaction = false;
                    division = false;
                }catch (Exception e){}


            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    first = Double.valueOf(t1.getText().toString());
                    t1.setText(null);
                    addition = true;
                    subtraction = false;
                    multipaction = false;
                    division = true;
                }catch (Exception e){}

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    first = Double.valueOf(t1.getText().toString());
                    t1.setText(null);
                    addition = true;
                    subtraction = false;
                    multipaction = true;
                    division = false;
                }catch (Exception e){}

            }
        });



    }
}
