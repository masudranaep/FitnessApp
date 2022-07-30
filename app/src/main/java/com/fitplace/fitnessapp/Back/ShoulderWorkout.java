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

import com.fitplace.fitnessapp.FmGYM.One.Chest.Fm_Warmap;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_Arnoldpress;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_BentletShol;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_Dumbbelpressshol;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_Frontraiseshol;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_Machineshol;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_MilitariPress;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_Singlecableshol;
import com.fitplace.fitnessapp.FmGYM.One.Shoulder.Fm_Uprightrows;
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

public class ShoulderWorkout extends AppCompatActivity {

    private AdLoader adLoader;
    private  InterstitialAd mInterstitialAd;
    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_shoulder_workout );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                loadRewaededAd ();

            }
        });


        //banner Ads

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        //Natve ads

        adLoader = new AdLoader.Builder ( ShoulderWorkout.this, "ca-app-pub-6814304072623948/2794571806" )
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

                        //smail template
                        TemplateView template2 = findViewById ( R.id.my_template2 );


                        template2.setStyles ( styles );
                        template2.setNativeAd ( NativeAd );

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
            Activity activityContext = ShoulderWorkout.this;
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





    public void Backpass(View view) {
        Intent intent = new Intent (ShoulderWorkout.this, Gym_type.class );
        startActivity ( intent );
    }

    public void ARNOLDDUMBBELLPRESS(View view) {
        Intent intent = new Intent (ShoulderWorkout.this, Fm_Arnoldpress.class );
        startActivity ( intent );


    }

    public void Warmup(View view) {

        Intent intent = new Intent (ShoulderWorkout.this, Fm_Warmap.class );
        startActivity ( intent );
    }

    public void ARMSDUMBBELLPRESS(View view) {

        Intent intent = new Intent (ShoulderWorkout.this, Fm_Dumbbelpressshol.class );
        startActivity ( intent );
    }

    public void BARBELLFRONTRAISES(View view) {
        Intent intent = new Intent (ShoulderWorkout.this, Fm_Frontraiseshol.class );
        startActivity ( intent );



    }

    public void MILITARYPRESS(View view) {

        Intent intent = new Intent (ShoulderWorkout.this, Fm_MilitariPress.class );
        startActivity ( intent );
    }

    public void BENTOVERLATERALRAISE(View view) {

        Intent intent = new Intent (ShoulderWorkout.this, Fm_BentletShol.class );
        startActivity ( intent );
    }

    public void UPRIGHTROWS(View view) {

        Intent intent = new Intent (ShoulderWorkout.this, Fm_Uprightrows.class );
        startActivity ( intent );
        showRewardedAd ();
    }

    public void SINGLEARMCABLERAISES(View view) {
        Intent intent = new Intent (ShoulderWorkout.this, Fm_Singlecableshol.class );
        startActivity ( intent );

    }

    public void SEATEDMACHINESHOULDERPRESS(View view) {

        Intent intent = new Intent (ShoulderWorkout.this, Fm_Machineshol.class );
        startActivity ( intent );
    }
}