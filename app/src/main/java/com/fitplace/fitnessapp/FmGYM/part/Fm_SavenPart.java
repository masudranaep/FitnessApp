package com.fitplace.fitnessapp.FmGYM.part;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fitplace.fitnessapp.FmGYM.FmGym;
import com.fitplace.fitnessapp.FmGYM.Fm_Contact;
import com.fitplace.fitnessapp.FmGYM.five.Fm_SevenpartOne;
import com.fitplace.fitnessapp.FmGYM.five.Fm_SevenpartThree;
import com.fitplace.fitnessapp.FmGYM.five.Fm_SevenpartTwo;
import com.example.fitnessapp.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class Fm_SavenPart extends AppCompatActivity {

    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_fm_saven_part );


        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });


//
////bennaer ads
//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);

    }






    public void FourOneGym(View view) {
        Intent intent = new Intent (Fm_SavenPart.this, Fm_SevenpartOne.class );
        startActivity ( intent );


    }

    public void FourONeDiet(View view) {
    }

    public void FourTwoGym(View view) {
        Intent intent = new Intent (Fm_SavenPart.this, Fm_SevenpartTwo.class );
        startActivity ( intent );


    }

    public void FourTwoDiet(View view) {
    }

    public void Backpass(View view) {
        Intent intent = new Intent (Fm_SavenPart.this, FmGym.class );
        startActivity ( intent );
    }

    public void FourThreeGym(View view) {
        Intent intent = new Intent (Fm_SavenPart.this, Fm_SevenpartThree.class );
        startActivity ( intent );
    }

    public void FourThreeDiet(View view) {
    }

    public void personal(View view) {
        Intent intent = new Intent ( Fm_SavenPart.this, Fm_Contact.class);
        startActivity ( intent );
    }
}