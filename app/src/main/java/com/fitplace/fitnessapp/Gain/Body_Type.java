package com.fitplace.fitnessapp.Gain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fitplace.fitnessapp.Flabby.FlabbyWeight;
import com.fitplace.fitnessapp.Heavier.HeaverWeight;
import com.fitplace.fitnessapp.MainActivity;
import com.example.fitnessapp.R;
import com.fitplace.fitnessapp.Skinny.SkinnyYear;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Body_Type extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_body_type );








    }

    public void Backpass(View view) {
        Intent intent = new Intent ( Body_Type.this, MainActivity.class );
        startActivity ( intent );

    }












    public void Skinny(View view) {

        Intent intent = new Intent ( Body_Type.this, SkinnyYear.class );
        startActivity ( intent );
    }

    public void Ideal(View view) {
        Intent intent = new Intent ( Body_Type.this, SkinnyYears.class );
        startActivity ( intent );
    }

    public void Flabby(View view) {
        Intent intent = new Intent ( Body_Type.this, FlabbyWeight.class );
        startActivity ( intent );


    }

    public void Heavier(View view) {
        Intent intent = new Intent ( Body_Type.this, HeaverWeight.class );
        startActivity ( intent );
    }





}

