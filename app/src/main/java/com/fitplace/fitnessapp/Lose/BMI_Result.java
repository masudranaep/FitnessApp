package com.fitplace.fitnessapp.Lose;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class BMI_Result extends AppCompatActivity {

    private AdView adView;

    Button mrecalculatebmi;
    TextView mbmidisplay, mbmicateogory, mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight, intweight;
    CardView mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_bmi_result );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //banner Ads
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


            // getSupportActionBar ().setElevation ( 0 );

//        getSupportActionBar ().setTitle ( Html.fromHtml ( "font color=\"white\"></font>" ) );
//        getSupportActionBar ().setTitle ( "Result" );
//        ColorDrawable colorDrawable = new ColorDrawable ( Color.parseColor ( "#1E1D1D" ) );
//        getSupportActionBar ().setBackgroundDrawable ( colorDrawable );

            intent = getIntent ();
            mbmidisplay = findViewById ( R.id.bmidisply );
            mbmicateogory = findViewById ( R.id.bmicategory );
            mgender = findViewById ( R.id.genderdisply );
            mbackground = findViewById ( R.id.contenlayout );
            mimageview = findViewById ( R.id.bmiimage );
            mrecalculatebmi = findViewById ( R.id.raculculatebmi );



            height = intent.getStringExtra ( "height" );
            weight = intent.getStringExtra ( "weight" );

            intheight = Float.parseFloat ( height );
            intweight = Float.parseFloat ( weight );


            intheight = intheight /100;
            intbmi = intweight/(intheight * intheight);
            mbmi = Float.toString ( intbmi );

            if(intbmi < 16){
                mbmicateogory.setText ( "Severe Thinness" );
                mbackground.setBackgroundColor ( Color.RED );
                mimageview.setImageResource ( R.drawable.cross );

            }else if(intbmi < 16.9 && intbmi > 16){

                mbmicateogory.setText ( "Moderate Thinness" );
                mbackground.setBackgroundColor (Color.RED );
                mimageview.setImageResource ( R.drawable.warning );

            }else if(intbmi < 18.4 && intbmi > 17){

                mbmicateogory.setText ( "Mild Thinness" );
                mbackground.setBackgroundColor (Color.RED );
                mimageview.setImageResource ( R.drawable.warning );

            }else if(intbmi < 25 && intbmi > 18.4){

                mbmicateogory.setText ( "Normal" );
                // mbackground.setBackgroundColor (Color.YELLOW);
                mimageview.setImageResource ( R.drawable.ok );

            }else if(intbmi < 29.4 && intbmi > 25){

                mbmicateogory.setText ( "Overweight" );
                mbackground.setBackgroundColor (Color.RED );
                mimageview.setImageResource ( R.drawable.warning );

            }else {

                mbmicateogory.setText ( "Obese Class 1" );
                mbackground.setBackgroundColor (Color.RED );
                mimageview.setImageResource ( R.drawable.warning );

            }

            mgender.setText ( intent.getStringExtra ( "gender" ) );
            mbmidisplay.setText ( mbmi );



            mrecalculatebmi.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (BMI_Result.this, BMI_Calculater.class);
                    startActivity ( intent );
                    finish ();
                }
            } );
        }
    }
