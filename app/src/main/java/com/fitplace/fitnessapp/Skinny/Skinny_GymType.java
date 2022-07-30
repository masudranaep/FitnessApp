package com.fitplace.fitnessapp.Skinny;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fitplace.fitnessapp.MenuItem.MyContact;
import com.example.fitnessapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Skinny_GymType extends AppCompatActivity {
    BottomSheetDialog sheetDialog;
    CardView cardAdd,twocardAdd;
    Button onebtn, twobtn;
    private InterstitialAd mInterstitialAd;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_skinny_gym_type );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        onebtn = findViewById ( R.id.cardadd );
        twobtn = findViewById ( R.id.cardadd );
        twocardAdd = findViewById ( R.id.forroutine );
        cardAdd = findViewById ( R.id.therdroutine );

//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
        setAds ();


    }

    //interstitialAd
    public  void setAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-6814304072623948/7500103571", adRequest,
                new InterstitialAdLoadCallback () {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });


    }

    public void Backpass(View view) {
        Intent intent = new Intent (Skinny_GymType.this, SkinnyYear.class);
        startActivity ( intent );
    }

    public void FourOneGym(View view) {
        Intent intent = new Intent (Skinny_GymType.this, OneRoutineGym.class);
        startActivity ( intent );


    }

    public void FourTwoGym(View view) {
        Intent intent = new Intent (Skinny_GymType.this, Two_RoutineGym.class);
        startActivity ( intent );

    }



    public void Personal(View view) {
        Intent intent = new Intent (Skinny_GymType.this, MyContact.class );
        startActivity ( intent );

    }



    public void FourTwoDiet(View view) {
        Intent intent = new Intent (Skinny_GymType.this,SkinnyDeit.class);
        startActivity ( intent );
        //interstitialAd

        if(mInterstitialAd != null){
            mInterstitialAd.show ( Skinny_GymType.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( Skinny_GymType.this, SkinnyDeit.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            startActivity ( new Intent (Skinny_GymType.this, SkinnyDeit.class) );
        }


    }


}