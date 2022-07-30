package com.fitplace.fitnessapp.Heavier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fitplace.fitnessapp.FmGYM.Fat.Fm_FatOne;
import com.fitplace.fitnessapp.FmGYM.Fat.Fm_FatTwo;
import com.fitplace.fitnessapp.MenuItem.MyContact;
import com.example.fitnessapp.R;
import com.fitplace.fitnessapp.Skinny.SkinnyWhatappAdd;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class HeavierGym_type extends AppCompatActivity {
    BottomSheetDialog sheetDialog;
    CardView cardAdd, twocardAdd;
    Button onebtn, twobtn;
    private AdView adView;


    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_heavier_gym_type );
        MobileAds.initialize ( this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        } );

        setAds ();
//
//        //benner ads
//        adView = findViewById ( R.id.adView );
//        AdRequest adRequest = new AdRequest.Builder ().build ();
//        adView.loadAd ( adRequest );

        onebtn = findViewById ( R.id.cardadd );
        twobtn = findViewById ( R.id.cardadd );
        twocardAdd = findViewById ( R.id.forroutine );
        cardAdd = findViewById ( R.id.therdroutine );

    }

    //interstitialAd
    public  void setAds() {
        AdRequest adRequest = new AdRequest.Builder ().build ();

        InterstitialAd.load ( this, "ca-app-pub-3940256099942544/1033173712", adRequest,
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


            public void Backpass (View view){
                Intent intent = new Intent ( HeavierGym_type.this, HeaverWeight.class );
                startActivity ( intent );
            }

            public void OneMonths (View view){
                Intent intent = new Intent ( HeavierGym_type.this, Fm_FatOne.class );
                startActivity ( intent );



            }

            public void HeaverDiet (View view){
                Intent intent = new Intent ( HeavierGym_type.this, HeaverDiet.class );
                startActivity ( intent );


            }

            public void Personal (View view){
        Intent intent = new Intent (HeavierGym_type.this, MyContact.class );
        startActivity ( intent );


                //interstitialAd
                if(mInterstitialAd != null){
                    mInterstitialAd.show ( HeavierGym_type.this );

                    mInterstitialAd.setFullScreenContentCallback ( new FullScreenContentCallback () {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent ();
                            startActivity (new Intent ( HeavierGym_type.this, MyContact.class ));
                            mInterstitialAd = null;
                            setAds ();
                        }
                    } );


                }else {
                    //startActivity ( new Intent (LossWeight.this, DayOne.class) );
                }


            }

            public void fourMonth (View view){
                twocardAdd.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        sheetDialog = new BottomSheetDialog ( HeavierGym_type.this, R.style.BottomSheetDialogTheme );
                        View view = LayoutInflater.from ( HeavierGym_type.this ).inflate ( R.layout.heavier_card_item, (LinearLayout) findViewById ( R.id.onesheetview ) );

                        view.findViewById ( R.id.addCard ).setOnClickListener ( new View.OnClickListener () {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent ( HeavierGym_type.this, SkinnyWhatappAdd.class );
                                startActivity ( intent );
                            }
                        } );
                        sheetDialog.setContentView ( view );
                        sheetDialog.show ();

                    }
                } );
            }



    public void TwoMonths(View view) {
        Intent intent = new Intent ( HeavierGym_type.this, Fm_FatTwo.class );
        startActivity ( intent );

    }
}

