package com.fitplace.fitnessapp.Back;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fitplace.fitnessapp.Gain.SkinnyYears;
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
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class Gym_type extends AppCompatActivity {

    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_gym_type );

        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                loadRewaededAd();

            }
        });

//        //benner ads
//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
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
    private void showRewardedAd(){
        if (mRewardedAd != null) {
            Activity activityContext = Gym_type.this;
            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener () {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    // Handle the reward.
                    Log.d(TAG, "The user earned the reward.");
                    int rewardAmount = rewardItem.getAmount();
                    String rewardType = rewardItem.getType();

                }
            });
        } else {
            Log.d(TAG, "The rewarded ad wasn't ready yet.");
        }




    }


    public void Backpass(View view) {
        Intent intent = new Intent (Gym_type.this, SkinnyYears.class );
        startActivity ( intent );
    }

    public void ChastWorkout(View view) {
        Intent intent = new Intent (Gym_type.this, Ideal_Chest.class );
        startActivity ( intent );

    }

    public void Backworkout(View view) {
        Intent intent = new Intent (Gym_type.this, BackWorkout.class );
        startActivity ( intent );

    }

    public void ARMSWORK(View view) {
        Intent intent = new Intent (Gym_type.this, ArmsWorkout.class );
        startActivity ( intent );

    }

    public void Shoulder(View view) {
        Intent intent = new Intent (Gym_type.this, ShoulderWorkout.class );
        startActivity ( intent );

    }

    public void Legs(View view) {
        Intent intent = new Intent (Gym_type.this, LegsWorkout.class );
        startActivity ( intent );
    }

    public void Tricep(View view) {
        Intent intent = new Intent (Gym_type.this, TricepWorkout.class );
        startActivity ( intent );

    }

    public void IdealDiet(View view) {
        Intent intent  = new Intent (Gym_type.this, Idealbody_Diet.class );
        startActivity ( intent );
        showRewardedAd();
    }


    public void personal(View view) {
        Intent intent = new Intent ( Gym_type.this, MyContact.class );
        startActivity ( intent );


    }
}