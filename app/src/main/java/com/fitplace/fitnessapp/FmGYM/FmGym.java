package com.fitplace.fitnessapp.FmGYM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.fitplace.fitnessapp.Back.LegsWorkout;
import com.fitplace.fitnessapp.FmGYM.Fat.Fm_FatOne;
import com.fitplace.fitnessapp.FmGYM.Fat.Fm_FatTwo;
import com.fitplace.fitnessapp.FmGYM.part.Fm_Fivepart;
import com.fitplace.fitnessapp.FmGYM.part.Fm_Fourpart;
import com.fitplace.fitnessapp.FmGYM.part.Fm_SavenPart;
import com.fitplace.fitnessapp.FmGYM.part.Fm_Sixpart;

import com.fitplace.fitnessapp.MainActivity;
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

public class FmGym extends AppCompatActivity {

    private AdLoader adLoader;
    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";
    private InterstitialAd mInterstitialAd;
    LinearLayout location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_fm_gym );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                loadRewaededAd ();
            }
        });

         setAds ();


         location = findViewById ( R.id.fmlocation );

//bennaer ads
       adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
       adView.loadAd(adRequest);


       location.setOnClickListener ( new View.OnClickListener () {
           @Override
           public void onClick(View v) {
               locationUrl("https://www.google.com.bd/maps/place/New+Famous+Gym/@23.8059864,90.371244,16.71z/data=!4m5!3m4!1s0x3755c0d4c1bb617b:0xf2207ca147159cc3!8m2!3d23.8062171!4d90.3737163");

           }
       } );


        //Natve ads

        adLoader = new AdLoader.Builder ( FmGym.this, "ca-app-pub-6814304072623948/2794571806" )
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

                        //smail template
                        TemplateView template = findViewById ( R.id.my_template );

                        //mediam template

                        template.setStyles ( styles );
                        template.setNativeAd ( NativeAd );





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



    // rewrded ads
    private void loadRewaededAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, "ca-app-pub-6814304072623948/4299225169",
                adRequest, new RewardedAdLoadCallback () {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        Log.d(TAG, loadAdError.getMessage());
                        mRewardedAd = null;
                        Log.d(TAG, "onAdFailedToload");
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                        Log.d(TAG, "Ad was loaded.");

                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback () {
                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                                Log.d(TAG, "Ad was shown.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.
                                Log.d(TAG, "Ad failed to show.");
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                Log.d(TAG, "Ad was dismissed.");
                                mRewardedAd = null;
                                loadRewaededAd ();
                            }
                        });
                    }
                });


    }
    private void showRewardedAd() {
        if (mRewardedAd != null) {
            Activity activityContext = FmGym.this;
            mRewardedAd.show ( activityContext, new OnUserEarnedRewardListener () {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    // Handle the reward.
                    Log.d ( TAG, "The user earned the reward." );
                    int rewardAmount = rewardItem.getAmount ();
                    String rewardType = rewardItem.getType ();

                }
            } );
        } else {
            Log.d ( TAG, "The rewarded ad wasn't ready yet." );
        }
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



    // location
    private void locationUrl(String s){
        Uri uri = Uri.parse ( s );
        startActivity ( new Intent (Intent.ACTION_VIEW, uri) );

    }


    public void Backpass(View view) {
        Intent intent = new Intent (FmGym.this, MainActivity.class);
        startActivity ( intent );
    }





    public void Fm_oneRoutine(View view) {
        Intent intent = new Intent (FmGym.this, FmOneroutine.class);
        startActivity ( intent );
    }

    public void Fm_tworoutibe(View view) {

        Intent intent = new Intent (FmGym.this, Fm_Tworoutine.class);
        startActivity ( intent );

    }

    public void Fm_foreRoutine(View view) {

        Intent intent = new Intent ( FmGym.this, Fm_Fourpart.class );
        startActivity ( intent );

    }

    public void Fm_fiveroutibe(View view) {
        Intent intent = new Intent ( FmGym.this, Fm_Fivepart.class );
        startActivity ( intent );

        //interstitialAd
        if(mInterstitialAd != null){
            mInterstitialAd.show ( FmGym.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( FmGym.this, Fm_Fivepart.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            //startActivity ( new Intent (LossWeight.this, DayOne.class) );
        }
    }

    public void Fm_sixRoutine(View view) {
        Intent intent = new Intent (FmGym.this, Fm_Sixpart.class);
        startActivity ( intent );

    }

    public void Fm_sevenroutibe(View view) {
        Intent intent = new Intent (FmGym.this, Fm_SavenPart.class );
        startActivity ( intent );

    }

    public void Fm_LegRoutine(View view) {
         Intent intent = new Intent (FmGym.this, LegsWorkout.class );
         startActivity ( intent );
    }

    public void Fm_fatOneRoutine(View view) {
        Intent intent = new Intent (FmGym.this, Fm_FatOne.class );
        startActivity ( intent );

    }

    public void Fm_fateTworoutibe(View view) {
        Intent intent = new Intent (FmGym.this, Fm_FatTwo.class );
        startActivity ( intent );




    }

    public void fmPersonal(View view) {
        Intent intent = new Intent (FmGym.this, Fm_Contact.class);
        startActivity ( intent);
        showRewardedAd ();

    }

    public void fmContact(View view) {
        Intent intent = new Intent (FmGym.this, Fm_Contact.class);
        startActivity ( intent );
    }


}