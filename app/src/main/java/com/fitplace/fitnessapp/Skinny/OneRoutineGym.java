package com.fitplace.fitnessapp.Skinny;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fitplace.fitnessapp.FmGYM.One.Arms.Fm_ArmsWork;
import com.fitplace.fitnessapp.FmGYM.One.Arms.Fm_ForeArms;
import com.fitplace.fitnessapp.FmGYM.One.Arms.Fm_Hammercurl;
import com.fitplace.fitnessapp.FmGYM.One.Arms.Fm_TricepPulley;
import com.fitplace.fitnessapp.FmGYM.One.Chest.Fm_D_Press;
import com.fitplace.fitnessapp.FmGYM.One.Chest.Fm_PushUp;
import com.fitplace.fitnessapp.FmGYM.One.Fm_ArmsFrontraise;
import com.fitplace.fitnessapp.FmGYM.One.Fm_ArmsSideraise;
import com.fitplace.fitnessapp.FmGYM.One.Fm_FrontBend;
import com.fitplace.fitnessapp.FmGYM.One.Fm_SideBend;
import com.fitplace.fitnessapp.FmGYM.One.Fm_SideTwisting;
import com.fitplace.fitnessapp.FmGYM.One.Fm_Stretching;
import com.fitplace.fitnessapp.FmGYM.One.Jogging;
import com.fitplace.fitnessapp.FmGYM.One.Legs.Fm_LegsSquat;
import com.fitplace.fitnessapp.MenuItem.MyContact;
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

public class OneRoutineGym extends AppCompatActivity {
    private AdLoader adLoader;
    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_one_routine_gym );
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




        //Natve ads

        adLoader = new AdLoader.Builder ( OneRoutineGym.this, "ca-app-pub-6814304072623948/2794571806" )
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
                     //   TemplateView template = findViewById ( R.id.my_template );

                        //mediam template
                        TemplateView template2 = findViewById ( R.id.my_template2 );
//
//                        template.setStyles ( styles );
//                        template.setNativeAd ( NativeAd );
//

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
            Activity activityContext = OneRoutineGym.this;
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
        Intent intent = new Intent (OneRoutineGym.this, Skinny_GymType.class);
        startActivity ( intent );
    }

    public void JOGGING(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Jogging.class);
        startActivity ( intent );

    }

    public void sideTwisting(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_SideTwisting.class);
        startActivity ( intent );
        showRewardedAd ();

    }

    public void Sidebend(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_SideBend.class);
        startActivity ( intent );
    }

    public void fontband(View view) {

        Intent intent = new Intent (OneRoutineGym.this, Fm_FrontBend.class);
        startActivity ( intent );
    }

    public void STRETCHING(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_Stretching.class);
        startActivity ( intent );



    }

    public void PUSHUP(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_PushUp.class);
        startActivity ( intent );

    }

    public void DUMBBELLPRESS(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_D_Press.class);
        startActivity ( intent );

    }

    public void ARMS_FRONT_RAISE(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_ArmsFrontraise.class);
        startActivity ( intent );

    }

    public void ARMS_SIDE_RAISE(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_ArmsSideraise.class);
        startActivity ( intent );


    }

    public void ARMSWORK(View view) {

        Intent intent = new Intent (OneRoutineGym.this, Fm_ArmsWork.class);
        startActivity ( intent );
    }

    public void HAMMERCURL(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_Hammercurl.class);
        startActivity ( intent );

    }

    public void TRECEPPULLEY(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_TricepPulley.class);
        startActivity ( intent );

        //interstitialAd
        if(mInterstitialAd != null){
            mInterstitialAd.show ( OneRoutineGym.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( OneRoutineGym.this, Fm_TricepPulley.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            //startActivity ( new Intent (LossWeight.this, DayOne.class) );
        }

    }

    public void FOREARMS(View view) {
        Intent intent = new Intent (OneRoutineGym.this, Fm_ForeArms.class);
        startActivity ( intent );

    }

    public void LEGSSQUAT(View view) {

        Intent intent = new Intent (OneRoutineGym.this, Fm_LegsSquat.class);
        startActivity ( intent );
    }

    public void personal(View view) {
        Intent intent = new Intent (OneRoutineGym.this, MyContact.class );
        startActivity ( intent );
    }
}