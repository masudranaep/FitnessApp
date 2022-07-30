package com.fitplace.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fitnessapp.R;

public class FontPage extends AppCompatActivity {
    Animation up, down;
    LinearLayout layout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_font_page );


        layout  = findViewById ( R.id.logo1 );

        up = AnimationUtils.loadAnimation ( getApplicationContext (),R.anim.up );
        layout.setAnimation ( up );


//        TextView textView = findViewById ( R.id.fitnessapp );
//        down = AnimationUtils.loadAnimation ( getApplicationContext (),R.anim.down );
//        textView.setAnimation ( down );

//        new Handler ().postDelayed ( new Runnable () {
//            @Override
//            public void run() {
//                startActivity ( new Intent (getApplicationContext (),MainActivity.class) );
//                finish ();
//            }
//        },3500 );



    }

    public void jonrny(View view) {
        Intent intent = new Intent (FontPage.this, MainActivity.class);
        startActivity ( intent );
    }
}