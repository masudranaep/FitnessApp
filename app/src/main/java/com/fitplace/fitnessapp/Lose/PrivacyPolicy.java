package com.fitplace.fitnessapp.Lose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.fitnessapp.R;

public class PrivacyPolicy extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_privacy_policy );


        getSupportActionBar ().setDisplayShowHomeEnabled ( true );
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );

        webView = findViewById ( R.id.webView );
        webView.setWebViewClient (  new WebViewClient () );

     //   webView.loadUrl ( "https://masudep43.blogspot.com/2022/01/fit-place-privacy-policy.html" );

        WebSettings webSettings = webView.getSettings ();
        webSettings.setJavaScriptEnabled ( true );

        webView.getSettings ().setBuiltInZoomControls ( true );
        webView.getSettings ().setDisplayZoomControls ( false );

    }





}