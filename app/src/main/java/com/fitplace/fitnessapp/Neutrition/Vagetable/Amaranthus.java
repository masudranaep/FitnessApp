package com.fitplace.fitnessapp.Neutrition.Vagetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessapp.R;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.rewarded.RewardedAd;

import java.util.List;

public class Amaranthus extends AppCompatActivity {

    RecyclerView recyclerView;

    private AdView adView;
    private InterstitialAd mInterstitialAd;

    private AdLoader adLoader;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_amaranthus );

        MobileAds.initialize ( this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        } );
//        //banner Ads
//
//        adView = findViewById ( R.id.adView );
//        AdRequest adRequest = new AdRequest.Builder ().build ();
//        adView.loadAd ( adRequest );


    }

    public void Backpass(View view) {
    }
}