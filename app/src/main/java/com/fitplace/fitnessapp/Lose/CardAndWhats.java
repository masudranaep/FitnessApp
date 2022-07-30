package com.fitplace.fitnessapp.Lose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fitnessapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class CardAndWhats extends AppCompatActivity {

    Button Whatsappbutton;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_card_and_whats );


        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        //banner Ads

//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);


        Whatsappbutton = findViewById ( R.id.whatsadd );
        String num = "+8801628702811";
        String text = "Welcome to My Fitness Apps";

        Whatsappbutton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                boolean installed = isAppInstalled("com.whatsapp");
                if(installed){
                    Intent intent = new Intent (Intent.ACTION_VIEW);
                    intent.setData ( Uri.parse ("http://api.whatsapp.com/send?phone="+num+"&text"+text) );
                    startActivity ( intent );
                }else {
                    Toast.makeText ( CardAndWhats.this, "Whatsapp is not installed",Toast.LENGTH_LONG ).show ();
                }
            }
        } );


    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager ();
        boolean is_installed;

    try {
        packageManager.getPackageInfo ( s, PackageManager.GET_ACTIVITIES );
        is_installed = true;

    }catch (PackageManager.NameNotFoundException e){
       is_installed = false;
       e.printStackTrace ();
       
    }
    return is_installed;
    }

    public void backpass(View view) {
        Intent intent = new Intent (CardAndWhats.this, LossWeight.class);
        startActivity ( intent );
    }
}