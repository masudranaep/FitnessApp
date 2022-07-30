package com.fitplace.fitnessapp.Skinny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.fitplace.fitnessapp.Gain.Body_Type;
import com.example.fitnessapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SkinnyYear extends AppCompatActivity {
    Button btn;
    TextView mcurrentheight;
    TextView mcurrentage, mcurrentweight;
    ImageView mincrementage, mincrementweight, mdecrentweight, mdecrementage;
    SeekBar seekbarheight;
    RelativeLayout mmale, mfemale;

    int intweight = 55;
    int intage = 22;
    int currentprogreess;
    String mintprogress = "170";
    String typeofuser = "0";
    String weight2= "55";
    String age2 = "22";
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_skinny_year );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

//        //banner ads
//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);


        mcurrentheight = findViewById ( R.id.currentheight );
        mcurrentage = findViewById ( R.id.currentage );
        mcurrentweight = findViewById ( R.id.currentweight );
        mincrementage = findViewById ( R.id.minusage );
        mdecrementage = findViewById ( R.id.plusage );
        mincrementweight = findViewById ( R.id.minusweight );
        mdecrentweight = findViewById ( R.id.plusweight );
        seekbarheight = findViewById (R.id.seekbar);
        mmale = findViewById ( R.id.male );
        mfemale = findViewById ( R.id.femal );



        btn  = findViewById ( R.id.continueButton );


        btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (SkinnyYear.this, Skinny_GymType.class);
                startActivity ( intent );
            }
        } );



        //male and female backgraund

        mmale.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                mmale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.maleorfemalefoucash) );
                mfemale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.femalefocash ) );
                typeofuser = "Male";
            }
        } );

        mfemale.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                mfemale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.maleorfemalefoucash) );
                mmale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.femalefocash ) );
                typeofuser = "Female";
            }
        } );

        //seekbar
        seekbarheight.setMax ( 300 );
        seekbarheight.setProgress ( 170 );
        seekbarheight.setOnSeekBarChangeListener ( new SeekBar.OnSeekBarChangeListener () {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentprogreess = progress;
                mintprogress = String.valueOf ( currentprogreess );
                mcurrentheight.setText ( mintprogress );


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        } );

        // plus minus

        mincrementage.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                intage = intage -1;
                age2 = String.valueOf ( intage );
                mcurrentage.setText ( age2 );
            }
        } );

        mdecrementage.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                intage = intage +1;
                age2 = String.valueOf ( intage );
                mcurrentage.setText ( age2 );
            }
        } );


        mincrementweight.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                intweight = intweight -1;
                weight2 = String.valueOf ( intweight );
                mcurrentweight.setText ( weight2 );
            }
        } );

        mdecrentweight.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                intweight = intweight +1;
                weight2 = String.valueOf ( intweight );
                mcurrentweight.setText ( weight2 );
            }
        } );

    }

    public void Backpass(View view) {
        Intent intent = new Intent (SkinnyYear.this, Body_Type.class);
        startActivity ( intent );
    }


}
