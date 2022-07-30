package com.fitplace.fitnessapp.Fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.R;
import com.example.fitnessapp.databinding.FragmentOnlineBinding;
import com.fitplace.fitnessapp.MenuItem.MyContact;

public class OnlineFragment extends Fragment {



    public OnlineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

    }

    FragmentOnlineBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOnlineBinding.inflate ( getLayoutInflater () );


        //facebook
        binding.textView17.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                gotoUrl ( "https://www.facebook.com/mdmasudranaep" );

            }
        } );

        binding.submitBytton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                email("https://webmail.au.syrahost.com/");

            }
        } );

        // Inflate the layout for this fragment
        return binding.getRoot ();
    }

    public void gotoUrl(String s){
        Uri uri = Uri.parse ( s );
        startActivity ( new Intent (Intent.ACTION_VIEW, uri) );

    }

    public void email(String s){
        Uri uri = Uri.parse ( s );
        startActivity ( new Intent (Intent.ACTION_VIEW, uri) );

    }



}