package com.fitplace.fitnessapp.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessapp.R;
import com.example.fitnessapp.databinding.FragmentProfileBinding;
import com.fitplace.fitnessapp.Lose.PrivacyPolicy;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

    }

    String num = "+8801628702811";
    String text = "Hello";

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate ( getLayoutInflater () );


        binding.PrivacyPolicy.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getContext (), PrivacyPolicy.class ) );

                //PrivacyPolicylink
                PrivacyPolicylink ( "https://masudep43.blogspot.com/2022/01/fit-place-privacy-policy.html" );


            }
        } );


        //share app

        //share app
        binding.shareapp.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( Intent.ACTION_SEND );
                intent.setType ( "text/plain" );
                String Body = "Download this App";
                String Sub = "http://play.google.com";
                intent.putExtra ( Intent.EXTRA_TEXT, Body );
                intent.putExtra ( Intent.EXTRA_TEXT, Sub );
                startActivity ( Intent.createChooser ( intent, "Share using" ) );

            }
        } );
        //univarsity

        binding.University.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                universityUrl("https://www.facebook.com/NUBDhaka" );

            }
        } );
  //facebook
        binding.facebook.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                facebookUrl("https://www.facebook.com/mdmasudranaep" );

            }
        } );

        return binding.getRoot ();
    }

       // PrivacyPolicylink

    private void PrivacyPolicylink(String s) {
        Uri uri = Uri.parse ( s );
        startActivity ( new Intent ( Intent.ACTION_VIEW, uri ) );
    }
    //facbook
    private void facebookUrl(String s) {
        Uri uri = Uri.parse ( s );
        startActivity ( new Intent (Intent.ACTION_VIEW, uri) );
    }
    //university
    private void universityUrl(String s) {
        Uri uri = Uri.parse ( s );
        startActivity ( new Intent (Intent.ACTION_VIEW, uri) );
    }

}
