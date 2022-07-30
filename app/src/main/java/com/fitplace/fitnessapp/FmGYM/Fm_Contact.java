package com.fitplace.fitnessapp.FmGYM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;


public class Fm_Contact extends AppCompatActivity {

    private AdLoader adLoader;
    private AdView adView;
    private RewardedAd mRewardedAd;
    private final String TAG = "--->AdMob";
     EditText fmEmail, fmsubject, fmMsg;
     Button Fmsent;
     TextView fmFacebook;

    String num = "+8801736003384";
    String text = "Welcome to New Famous Gym";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_fm_contact );


        MobileAds.initialize(this, new OnInitializationCompleteListener () {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });


        //banner Ads

//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);


        fmEmail = findViewById ( R.id.edit_text_to );
        fmsubject = findViewById ( R.id.edit_text_subject );
        fmMsg = findViewById ( R.id.edit_text_message );
        Fmsent = findViewById ( R.id.button_send );

        fmFacebook = findViewById ( R.id.facebook );


        Fmsent.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        } );




//facebook link
        fmFacebook.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.facebook.com/nibir.ahmed.184");
            }

        } );


    }

    //email send
    private  void sendMail(){

        String recipientList = fmEmail.getText ().toString ();
        String[] recipients = recipientList.split ( "," );

        String subject = fmsubject.getText ().toString ();
        String message = fmMsg.getText ().toString ();

        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.putExtra ( Intent.EXTRA_EMAIL, recipients );
        intent.putExtra ( Intent.EXTRA_SUBJECT, subject );
        intent.putExtra ( Intent.EXTRA_TEXT, message );

        intent.setType ( "message/rfc422" );
        startActivity ( Intent.createChooser ( intent, "choose an email client" ) );
    }





// facebook
    private void gotoUrl(String s){
        Uri uri = Uri.parse ( s );
        startActivity ( new Intent (Intent.ACTION_VIEW, uri) );
    }

    public void Backpass(View view) {
        Intent intent = new Intent (Fm_Contact.this, FmGym.class);
        startActivity ( intent );
    }

    public void fmFacebook(View view) {
    }

    //whatsapp
    public void fmwhatapp(View view) {
        boolean installed = isAppInstalled("com.whatsapp");
        if(installed){
            Intent intent = new Intent (Intent.ACTION_VIEW);
            intent.setData ( Uri.parse ("http://api.whatsapp.com/send?phone="+num+"&text"+text) );
            startActivity ( intent );
        }else {
            Toast.makeText ( Fm_Contact.this, "Whatsapp is not installed",Toast.LENGTH_LONG ).show ();
        }


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

}