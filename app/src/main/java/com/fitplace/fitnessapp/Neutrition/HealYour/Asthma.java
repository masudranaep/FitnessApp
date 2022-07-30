package com.fitplace.fitnessapp.Neutrition.HealYour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fitplace.fitnessapp.Neutrition.BestFood.Garlic;
import com.fitplace.fitnessapp.Neutrition.BestFood.Ginger;
import com.fitplace.fitnessapp.Neutrition.Fruits.Almonds;
import com.fitplace.fitnessapp.Neutrition.Fruits.Apple;
import com.fitplace.fitnessapp.Neutrition.Fruits.Blueberries;
import com.fitplace.fitnessapp.Neutrition.Fruits.Lemon;
import com.fitplace.fitnessapp.Neutrition.NonVege.Salmon;
import com.fitplace.fitnessapp.Neutrition.Vagetable.Carrots;
import com.fitplace.fitnessapp.Neutrition.Vagetable.LimaBeans;
import com.fitplace.fitnessapp.Neutrition.Vagetable.Spinach;
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

public class Asthma extends AppCompatActivity {

    private AdLoader adLoader;
    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_asthma );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                loadRewaededAd ();

            }
        });

        setAds ();
        //banner Ads

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


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
            Activity activityContext = Asthma.this;
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



    public void Backpass(View view) {
        Intent intent = new Intent (Asthma.this, HealYourBody.class);
        startActivity ( intent );
    }

    public void Apple(View view) {
        Intent intent = new Intent (Asthma.this, Apple.class);
        startActivity ( intent );
    }

    public void Carrots(View view) {
        Intent intent = new Intent (Asthma.this, Carrots.class);
        startActivity ( intent );

    }

    public void Garilic(View view) {
        Intent intent = new Intent (Asthma.this, Garlic.class);
        startActivity ( intent );

        //interstitialAd
        if(mInterstitialAd != null){
            mInterstitialAd.show ( Asthma.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( Asthma.this, Garlic.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            //startActivity ( new Intent (LossWeight.this, DayOne.class) );
        }

    }

    public void Lemon(View view) {
        Intent intent = new Intent (Asthma.this, Lemon.class);
        startActivity ( intent );

    }

    public void Spinach(View view) {

        Intent intent = new Intent (Asthma.this, Spinach.class);
        startActivity ( intent );

    }

    public void Ginger(View view) {
        Intent intent = new Intent (Asthma.this, Ginger.class);
        startActivity ( intent );

    }

    public void Blueberries(View view) {

        Intent intent = new Intent (Asthma.this, Blueberries.class);
        startActivity ( intent );
        showRewardedAd ();
    }

    public void LimaBeans(View view) {
        Intent intent = new Intent (Asthma.this, LimaBeans.class);
        startActivity ( intent );

    }

    public void Almonds(View view) {
        Intent intent = new Intent (Asthma.this, Almonds.class);
        startActivity ( intent );

    }

    public void Salmon(View view) {
        Intent intent = new Intent (Asthma.this, Salmon.class);
        startActivity ( intent );



    }
}