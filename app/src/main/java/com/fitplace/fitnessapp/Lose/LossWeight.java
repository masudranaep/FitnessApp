package com.fitplace.fitnessapp.Lose;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fitplace.fitnessapp.AllDay.DayFive;
import com.fitplace.fitnessapp.AllDay.DayFour;
import com.fitplace.fitnessapp.AllDay.DayOne;
import com.fitplace.fitnessapp.AllDay.DaySaven;
import com.fitplace.fitnessapp.AllDay.DaySix;
import com.fitplace.fitnessapp.AllDay.DayThree;
import com.fitplace.fitnessapp.AllDay.DayTwo;
import com.fitplace.fitnessapp.MainActivity;
import com.example.fitnessapp.R;
import com.google.android.gms.ads.AdError;
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
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class LossWeight extends AppCompatActivity {

    LinearLayout upgrandAddCard, lossthreekg, lossTenKG;

    BottomSheetDialog sheetDialog;
    private AdView adView;
    private InterstitialAd mInterstitialAd;

    private AdLoader adLoader;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_loss_weight );


        MobileAds.initialize ( this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
               loadRewaededAd ();
            }
        } );

        setAds ();
//
//        //banner Ads
//        adView = findViewById ( R.id.adView );
//        AdRequest adRequest = new AdRequest.Builder ().build ();
//        adView.loadAd ( adRequest );

        lossthreekg = findViewById ( R.id.lossThreekG );
    }


//
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

    // rewrded ads
    private void loadRewaededAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, "ca-app-pub-6814304072623948/4299225169",
                adRequest, new RewardedAdLoadCallback() {
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

                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
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
            Activity activityContext = LossWeight.this;
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

    public void LossThreekg(View view) {
        lossthreekg.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sheetDialog = new BottomSheetDialog ( LossWeight.this, R.style.BottomSheetDialogTheme );
                View view  = LayoutInflater.from ( LossWeight.this ).inflate ( R.layout.loss_three_sheet, (LinearLayout)findViewById ( R.id.lossThree ) );

                view.findViewById ( R.id.addCard ).setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent (LossWeight.this, CardAndWhats.class);
                        startActivity ( intent );
                    }
                } );
                sheetDialog.setContentView ( view );
                sheetDialog.show ();
            }
        } );


    }
    public void sunday(View view) {

        Intent intent = new Intent (LossWeight.this, DayOne.class);
        startActivity ( intent );
    }

    public void monday(View view) {
        Intent intent = new Intent (LossWeight.this, DayTwo.class);
        startActivity ( intent );

    }

    public void Tueday3(View view) {
        Intent intent = new Intent (LossWeight.this, DayThree.class);
        startActivity ( intent );

    }

    public void wetday4(View view) {
        Intent intent = new Intent (LossWeight.this, DayFour.class);
        startActivity ( intent );

        showRewardedAd ();
    }

    public void theday5(View view) {

        Intent intent = new Intent (LossWeight.this, DayFive.class);
        startActivity ( intent );

    }

    public void friday6(View view) {
        Intent intent = new Intent (LossWeight.this, DaySix.class);
        startActivity ( intent );

    }

    public void studay7(View view) {

        Intent intent = new Intent (LossWeight.this, DaySaven.class);
        startActivity ( intent );

        //interstitial ads
        if(mInterstitialAd != null){
            mInterstitialAd.show ( LossWeight.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity ( new Intent (LossWeight.this, DayFour.class) );
                    mInterstitialAd = null;
                    setAds ();
                }
            } );
        }else {
            // startActivity ( new Intent (LossWeight.this, DayFour.class) );
        }

    }


    public void Backpass(View view) {
        Intent intent = new Intent (LossWeight.this, MainActivity.class);
        startActivity ( intent );

    }
}