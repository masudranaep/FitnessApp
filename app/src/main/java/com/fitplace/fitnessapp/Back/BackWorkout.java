package com.fitplace.fitnessapp.Back;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fitplace.fitnessapp.FmGYM.One.Back.Fm_BackPulley;
import com.fitplace.fitnessapp.FmGYM.One.Back.Fm_BendOverrow;
import com.fitplace.fitnessapp.FmGYM.One.Back.Fm_ChinUp;
import com.fitplace.fitnessapp.FmGYM.One.Back.Fm_Dumbbellrow;
import com.fitplace.fitnessapp.FmGYM.One.Back.Fm_SeatedCable;
import com.fitplace.fitnessapp.FmGYM.One.Back.Fm_Vbarlatpulldown;
import com.fitplace.fitnessapp.FmGYM.One.Chest.Fm_Warmap;
import com.fitplace.fitnessapp.FmGYM.One.Legs.Fm_Deadlift;
import com.example.fitnessapp.R;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
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
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.List;

public class BackWorkout extends AppCompatActivity {

    private AdLoader adLoader;
    private  InterstitialAd mInterstitialAd;
    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_back_workout );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        setAds ();

        //banner Ads



        //Natve ads

        adLoader = new AdLoader.Builder ( BackWorkout.this, "ca-app-pub-6814304072623948/2794571806" )
                .forNativeAd ( new NativeAd.OnNativeAdLoadedListener () {
                    @Override
                    public void onNativeAdLoaded(NativeAd NativeAd) {
                        // Show the ad.

                        //check if ad has loaded. If you are  loading multiole native ads then you must cheack;
                        if (!adLoader.isLoading ()) {


                            // Handle the failure by logging, altering the UI, and so on.
                        }

                        // check if activity is destroyed
                        if (isDestroyed ()) {
                            NativeAd.destroy ();

                        }
                        //we are uing Native ad build in temptel

                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder ().withMainBackgroundColor ( new ColorDrawable ( Color.WHITE ) ).build ();

//                        //smail template
//                        TemplateView template = findViewById ( R.id.my_template );
//
//
//                        template.setStyles ( styles );
//                        template.setNativeAd ( NativeAd );



                        //Or you cal also show native ads
                        final String getHeadLine = NativeAd.getHeadline ();
                        final NativeAd.Image getIcon = NativeAd.getIcon ();
                        final String getDetails = NativeAd.getBody ();
                        final String getAdvertierName = NativeAd.getAdvertiser ();
                        final String getPrice = NativeAd.getPrice ();
                        final double getRating = NativeAd.getStarRating ();
                        final List<NativeAd.Image> images = NativeAd.getImages ();

                    }
                } )
                .withAdListener ( new AdListener () {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {

                    }
                } )
                .withNativeAdOptions ( new NativeAdOptions.Builder ()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build () )
                .build ();
        //making request google
        //single ads
        adLoader.loadAd ( new AdRequest.Builder ().build () );
        //maxmum 5
        //adLoader.loadAds(new AdRequest.Builder().build(), 3);




    }

    //interstitialAd
    public  void setAds() {
        AdRequest adRequest = new AdRequest.Builder ().build ();

        InterstitialAd.load ( this, "ca-app-pub-6814304072623948/7500103571", adRequest,
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
                } );

    }





    public void Backpass(View view) {
        Intent intent = new Intent (BackWorkout.this, Gym_type.class );
        startActivity ( intent );
    }

    public void BackPulley(View view) {
        Intent intent = new Intent (BackWorkout.this, Fm_BackPulley.class );
        startActivity ( intent );




    }

    public void Backpassa(View view) {
        Intent intent = new Intent (BackWorkout.this, Fm_BackPulley.class );
        startActivity ( intent );

    }

    public void DumbbellRow(View view) {

        Intent intent = new Intent (BackWorkout.this, Fm_Dumbbellrow.class );
        startActivity ( intent );
    }

    public void Deatlift(View view) {

        Intent intent = new Intent (BackWorkout.this, Fm_Deadlift.class );
        startActivity ( intent );
    }

    public void V_barletpulley(View view) {

        Intent intent = new Intent (BackWorkout.this, Fm_Vbarlatpulldown.class );
        startActivity ( intent );
    }

    public void SEatedCable(View view) {
        Intent intent = new Intent (BackWorkout.this, Fm_SeatedCable.class );
        startActivity ( intent );
        //interstitialAd
        if(mInterstitialAd != null){
            mInterstitialAd.show ( BackWorkout.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( BackWorkout.this, Fm_Vbarlatpulldown.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            //startActivity ( new Intent (LossWeight.this, DayOne.class) );
        }



    }



    public void BEntoverows(View view) {
        Intent intent = new Intent (BackWorkout.this, Fm_BendOverrow.class );
        startActivity ( intent );

    }

    public void Chinup(View view) {
        Intent intent = new Intent (BackWorkout.this, Fm_ChinUp.class );
        startActivity ( intent );



    }

    public void Warmup(View view) {
        Intent intent = new Intent (BackWorkout.this, Fm_Warmap.class );
        startActivity ( intent );

    }
}