package com.example.gourav.truthdare;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] Truth={"What are you most self-conscious about?",

            "What is the most embarrassing picture of you?",

            "What would you do if you were the opposite sex for a month?",
            "What is the most expensive thing you have stolen?",
            "What is the most childish thing you still do?",
            "Have you ever let someone take the blame for something you did?",
            "What do most of your friends think about you that is totally untrue?",

            "Who here would you most like to make out with?",

            "Have you ever cheated or been cheated on?",

            "What lie have you told that hurt someone?",

            "What is the meanest you have been to someone that didn’t deserve it?",

            "What is something that people think you would never do but you have?",

            "What was the worst encounter you had with a police officer?",

            "Tell me about your most awkward date.",

            "What is the silliest thing you have an emotional attachment to?",

            "What is your deepest darkest fear?",

            "Tell me about your first kiss.",

            "Where is the strangest place you have peed?",

            "Who is the person you most regret kissing?",

            "Have you ever crapped your pants since you were a child?",

            "What is the most embarrassing thing your parents have caught you doing?",

            "What secret about yourself did you tell someone in confidence and then they told a lot of other people?",

            "When was the most inappropriate time you farted?",

            "What is the scariest dream you have ever had?",

            "What is the most embarrassing thing in your room?",

            "Why did you break up with your last boyfriend or girlfriend?",

            "What is the stupidest thing you have ever done?",

            "When was the last time you peed in bed?",

            "Who is the sexiest person here?",

            "What is the grossest thing that has come out of your body?",

            "What terrible thing have you done that you lied to cover up?",


            "Who have you loved but they didn’t love you back?",

            "What is something that you have never told anyone?",

            "What is the most disgusting habit you have?",

            "What was the cruelest joke you played on someone?",

            "Who here has the nicest butt?",


            "What is your biggest regret?",



            "When was the last time you picked your nose without a tissue?",


            "Tell us your most embarrassing vomit story.",

            "Tell me something you don’t want me to know.",

            "Have you ever made out with someone here?",

            "What is the airspeed velocity of an unladen swallow?",

            "What have you done that people here would judge you most for doing?",

            "What would you do if you were the opposite gender for a day?",

            "Who is your crush?"
    };

    String[] Dare ={"For a guy, put on makeup. For a girl, wash off your make up.",

            "Dance with no music for 1 minute.",

            "Try to drink a glass water while standing on your hands.",

            "Let the group pose you in an embarrassing position and take a picture.",

            "Curse like sailor for 20 seconds straight.",

            "Do four cartwheels in row.",

            "Play a song on by slapping your butt cheeks till someone guesses the song.",

            "Give someone your phone and let them send one text to anyone in your contacts.",

            "Depict a human life through interpretive dance.",

            "Lick the floor.",

            "Drink a small cup of a concoction that the group makes. (Don’t make anything that might cause bodily harm. No visits to the emergency room.).",

            "Write something embarrassing somewhere on your body (that can be hidden with clothing) with a permanent marker.",

            "Let someone shave part of your body.",

            "Eat five spoonfuls of a condiment.",

            "Let the group give you a new hairstyle.",

            "Make every person in the group smile, keep going until everyone has cracked a smiled.",

            "Sniff the armpits of everyone in the room.",

            "Let the person to your left draw on your face with a pen.",

            "Make up a 30 second opera about a person or people in the group and perform it.",

            "Serenade the person to your right.",

            "Talk in an accent for the next 3 rounds.",

            "Beg and plead the person to your right not to leave you for that other boy or girl. Weeping, gnashing of teeth, and wailing is encouraged.",
            "Attempt to break dance for 30 seconds.",

            "Kiss the person to your left.",

            "Do push ups until you can’t do any more, wait 5 seconds, and then do one more.",

            "Let the group look through your phone for 2 minutes.",

            "Attempt to do a magic trick.",

            "Do your best impression of a baby being born."

    };
    TextView tv;
    Button ready;
    TextView dailogtv;
    ImageView bottel;
    RadioButton truthr,darer;
    int truthlenght=0;
    int darelength=0;
    Dialog da;
    private String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        truthlenght=Truth.length;
        darelength=Dare.length;

        bottel=findViewById(R.id.bottle);
        truthr=findViewById(R.id.truth);
        darer=findViewById(R.id.dare);
        da=dailog();
        tv=findViewById(R.id.tv);
        bottel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic("qqq");
                int[] dir={0,60,120,180,240,300,360};
                Random rad1=new Random();
                int th=rad1.nextInt(dir.length-1);
                boolean isTruth=false;
                if(truthr.isSelected()){
                    isTruth=true;
                }
                rotate(bottel,dir[th],isTruth);

            }
        });
        dailogtv=da.findViewById(R.id.tv);
        ready=da.findViewById(R.id.ready);

//        go.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int[] dir={0,60,120,180,240,300,360};
//                Random rad1=new Random();
//                int th=rad1.nextInt(dir.length-1);
//                boolean isTruth=false;
//                if(truthr.isSelected()){
//                    isTruth=true;
//                }
//                rotate(bottel,dir[th],isTruth);
//            }
//        });





        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                da.dismiss();
            }
        });





    }






    public void rotate(ImageView v, final int mul, final boolean isTr){
        ObjectAnimator ghb=ObjectAnimator.ofFloat(v, View.ROTATION,0,(4*360)+mul);
        ghb.setDuration(4000);
        ghb.setInterpolator(new AccelerateDecelerateInterpolator());
        ghb.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                Random rad=new Random();
                String finaltruth=Truth[rad.nextInt(truthlenght-1)];
                String finaldare=Dare[rad.nextInt(darelength-1)];
                //Log.d(TAG, "onAnimationEnd:     "+finaltruth);
                // Log.d(TAG, "onAnimationEnd: "+finaldare);
                //Log.d(TAG, "onAnimationEnd: "+String.valueOf(mul));
                if(isTr){
                    dailogtv.setText(finaltruth);
                }else{
                    dailogtv.setText(finaldare);
                }

                da.show();


            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ghb.start();
    }

    public Dialog dailog(){
        Dialog dai=new Dialog(this);
        View v= LayoutInflater.from(this).inflate(R.layout.dialouge,null);
        dai.setContentView(v);
        dai.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return dai;
    }
    public void playMusic(String view){

        int id=getResources().getIdentifier(view,"raw","com.example.gourav.truthdare");
        MediaPlayer md=MediaPlayer.create(this,id);
        md.start();

    }
}
