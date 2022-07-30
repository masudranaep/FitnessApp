package com.fitplace.fitnessapp.Skinny;

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


public class SkinnyWhatappAdd extends AppCompatActivity {

    private AdView adView;
    Button whatappaddbutn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_skinny_whatapp_add );
        whatappaddbutn = findViewById ( R.id.whatsadd );
        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        String num = "01628702811";
        String  text = "Hi";

        //benner ads
        adView = findViewById ( R.id.adView );
        AdRequest adRequest = new AdRequest.Builder ().build ();
        adView.loadAd ( adRequest );

        whatappaddbutn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                boolean installed = isAppinstalled("com.whatsapp");
                if(installed){
                    Intent intent = new Intent (Intent.ACTION_VIEW);
                    intent.setData ( Uri.parse ("http://api.whatsapp.com/send?phone="+num+"&text"+text) );
                    startActivity ( intent );

                }else {
                    Toast.makeText ( SkinnyWhatappAdd.this, "Whats App not installed !", Toast.LENGTH_LONG ).show ();
                }
            }
        } );

    }

    private boolean isAppinstalled(String s){
        PackageManager packageManager = getPackageManager ();
        boolean is_installed ;
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
        Intent intent = new Intent (SkinnyWhatappAdd.this, Skinny_GymType.class);
        startActivity ( intent );
    }
}