package com.fitplace.fitnessapp.Time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class TimeWorkout extends AppCompatActivity {

    String buttonvalue;
    Button startbutton;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MtimeRunnig;
    private long MTimeLefttimemills;

  private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_time_workout );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //benner ads
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        startbutton = findViewById ( R.id.startbtn );
        mtextview = findViewById ( R.id.time );

        startbutton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                if(MtimeRunnig){
                    stoptime ();

                }else {

                    starttime ();
                }
            }
        } );
    }
    private void stoptime(){

        countDownTimer.cancel ();
        MtimeRunnig = false;
        startbutton.setText ( "START" );
    }
    private void starttime(){

        final CharSequence value1 = mtextview.getText ();
        String num1 = value1.toString ();
        String num2 = num1.substring ( 0,2 );
        String num3 = num1.substring ( 3,5 );


        final  int  number = Integer.valueOf ( num2 ) * 60 + Integer.valueOf ( num3 );
        MTimeLefttimemills = number * 1000;

        countDownTimer = new CountDownTimer (MTimeLefttimemills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                MTimeLefttimemills = millisUntilFinished;

                updateTimer();

            }

            @Override
            public void onFinish() {

                int namevalue = Integer.valueOf ( buttonvalue ) + 1;
                if(namevalue <= 7){

                    Intent intent = new Intent (TimeWorkout.this, TimeWorkout.class);
                    intent.addFlags ( Intent.FLAG_ACTIVITY_CLEAR_TASK );
                    startActivity ( intent );
                }else{

                    namevalue = 1;
                    Intent intent = new Intent (TimeWorkout.this, TimeWorkout.class);
                    intent.addFlags ( Intent.FLAG_ACTIVITY_CLEAR_TASK );
                    startActivity ( intent );

                }
            }
        }.start ();
        startbutton.setText ( "pause" );
        MtimeRunnig = true;
    }
    private  void updateTimer(){

        int minutes = (int) MTimeLefttimemills/60000;
        int seconds = (int) MTimeLefttimemills % 60000 /1000;

        String timeLeftText = "";
        if(minutes <10)
            timeLeftText = "0";
        timeLeftText = timeLeftText + minutes +":";

        if( seconds <10)
            timeLeftText += "0";
        timeLeftText += seconds;
        mtextview.setText ( timeLeftText );
    }
    public  void onBackPressed(){
        super.onBackPressed ();
    }
}