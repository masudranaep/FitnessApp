package com.fitplace.fitnessapp.Flabby;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fitplace.fitnessapp.MenuItem.MyContact;
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

public class FlabbyGym_type extends AppCompatActivity {

    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_flabby_gym_type );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {



            }
        });

        //benner ads
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
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
        Intent intent = new Intent (FlabbyGym_type.this, FlabbyWeight.class);
        startActivity ( intent );
    }

    public void FlabbyDiet(View view) {
        Intent intent = new Intent (FlabbyGym_type.this, FlabbyDite.class);
        startActivity ( intent );


    }


    public void FlabbyOne(View view) {
        Intent intent = new Intent (FlabbyGym_type.this, FlabbyOne.class);
        startActivity ( intent );

        //interstitialAd

        if(mInterstitialAd != null){
            mInterstitialAd.show ( FlabbyGym_type.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( FlabbyGym_type.this, FlabbyOne.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            //  startActivity ( new Intent (Vegetable.this, Amaranthus.class) );
        }

    }


    public void FlabbyTwoGym(View view) {
        Intent intent = new Intent (FlabbyGym_type.this, FlabbyTwo.class);
        startActivity ( intent );

    }


    public void personal(View view) {
        Intent intent = new Intent (FlabbyGym_type.this, MyContact.class);
        startActivity ( intent );



    }
}