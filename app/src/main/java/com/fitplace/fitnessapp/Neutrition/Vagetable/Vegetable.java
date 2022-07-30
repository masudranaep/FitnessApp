package com.fitplace.fitnessapp.Neutrition.Vagetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fitplace.fitnessapp.Neutrition.BestFood.SweetPototo;
import com.fitplace.fitnessapp.Neutrition.Fruits.Lemon;
import com.fitplace.fitnessapp.Neutrition.NutritionFacts;
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

public class Vegetable extends AppCompatActivity {

    private AdLoader adLoader;
    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_vegetable );
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

        adLoader = new AdLoader.Builder ( Vegetable.this, "ca-app-pub-6814304072623948/2794571806" )
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
                       // TemplateView template = findViewById ( R.id.my_template );

                        //mediam template
                        TemplateView template2 = findViewById ( R.id.my_template2 );


//
//                        template.setStyles ( styles );
//                        template.setNativeAd ( NativeAd );


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
            Activity activityContext = Vegetable.this;
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
        Intent intent = new Intent (Vegetable.this, NutritionFacts.class);
        startActivity ( intent );

    }

    public void Amaranthus(View view) {
        Intent intent = new Intent (Vegetable.this, Amaranthus.class);
        startActivity ( intent );



    }



    public void Asparagus(View view) {
        Intent intent = new Intent (Vegetable.this, Asparagus.class);
        startActivity ( intent );

    }



    public void Beetroot(View view) {
        Intent intent = new Intent (Vegetable.this, Beetroot.class);
        startActivity ( intent );





    }

    public void BellPapper(View view) {
        Intent intent = new Intent (Vegetable.this, Bellpepper.class);
        startActivity ( intent );

    }


    public void Brinjal(View view) {
        Intent intent = new Intent (Vegetable.this, Brinjal.class);
        startActivity ( intent );

showRewardedAd ();

    }

    public void Brocoli(View view) {
        Intent intent = new Intent (Vegetable.this, Broccoli.class);
        startActivity ( intent );

    }

    public void Cabbage(View view) {
        Intent intent = new Intent (Vegetable.this, Cabbage.class);
        startActivity ( intent );


        //interstitialAd
        if(mInterstitialAd != null){
            mInterstitialAd.show ( Vegetable.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( Vegetable.this, Cabbage.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            //  startActivity ( new Intent (Vegetable.this, Amaranthus.class) );
        }
    }

    public void Carrots(View view) {
        Intent intent = new Intent (Vegetable.this, Carrots.class);
        startActivity ( intent );
    }

    public void Cauliflower(View view) {
        Intent intent = new Intent (Vegetable.this, CauliFlower.class);
        startActivity ( intent );


    }


    public void Cucumber(View view) {
        Intent intent = new Intent (Vegetable.this, Cuumber.class);
        startActivity ( intent );

    }


    public void GreenPeas(View view) {
        Intent intent = new Intent (Vegetable.this, GreenPeas.class);
        startActivity ( intent );

    }


    public void Lettuce(View view) {
        Intent intent = new Intent (Vegetable.this, Lemon.class);
        startActivity ( intent );


    }



    public void Potato(View view) {
        Intent intent = new Intent (Vegetable.this, Potato.class);
        startActivity ( intent );


    }

    public void Pumpkin(View view) {
        Intent intent = new Intent (Vegetable.this, Pumpkin.class);
        startActivity ( intent );


    }



    public void SweetPotato(View view) {
        Intent intent = new Intent (Vegetable.this, SweetPototo.class);
        startActivity ( intent );
    }



    public void BottleGourd(View view) {
        Intent intent = new Intent (Vegetable.this, BottleGourd.class);
        startActivity ( intent );

    }

    public void Mustard(View view) {
        Intent intent = new Intent (Vegetable.this, Mustard.class);
        startActivity ( intent );


        //interstitialAd

        if(mInterstitialAd != null){
            mInterstitialAd.show ( Vegetable.this );

            mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent ();
                    startActivity (new Intent ( Vegetable.this, Mustard.class ));
                    mInterstitialAd = null;
                    setAds ();
                }
            } );


        }else {
            //  startActivity ( new Intent (Vegetable.this, Amaranthus.class) );
        }
    }

    public void Yardlang(View view) {
        Intent intent = new Intent (Vegetable.this, Mustard.class);
        startActivity ( intent );

    }

    public void LimaBeans(View view) {
        Intent intent = new Intent (Vegetable.this, LimaBeans.class);
        startActivity ( intent );

    }

    public void Basella(View view) {
        Intent intent = new Intent (Vegetable.this, Basella.class);
        startActivity ( intent );


    }

    public void BitterGourd(View view) {
        Intent intent = new Intent (Vegetable.this, BitterGourd.class);
        startActivity ( intent );
        showRewardedAd ();
    }
}