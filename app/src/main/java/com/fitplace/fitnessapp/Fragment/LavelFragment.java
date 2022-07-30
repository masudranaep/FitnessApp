package com.fitplace.fitnessapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessapp.R;
import com.example.fitnessapp.databinding.FragmentLavelBinding;
import com.fitplace.fitnessapp.AllDay.DayFive;
import com.fitplace.fitnessapp.AllDay.DayFour;
import com.fitplace.fitnessapp.AllDay.DayOne;
import com.fitplace.fitnessapp.AllDay.DaySaven;
import com.fitplace.fitnessapp.AllDay.DaySix;
import com.fitplace.fitnessapp.AllDay.DayThree;
import com.fitplace.fitnessapp.AllDay.DayTwo;
import com.fitplace.fitnessapp.MenuItem.MyContact;


public class LavelFragment extends Fragment {



    public LavelFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

    }
 FragmentLavelBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLavelBinding.inflate ( getLayoutInflater () );


        binding.day1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), DayOne.class ) );
            }
        } );
        binding.day2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), DayTwo.class ) );
            }
        } );
        binding.day3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), DayThree.class ) );
            }
        } );

        binding.day4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), DayFour.class ) );
            }
        } );

        binding.day5.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), DayFive.class ) );
            }
        } );

        binding.day6.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), DaySix.class ) );
            }
        } );
        binding.day7.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), DaySaven.class ) );
            }
        } );

        binding.day30.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), MyContact.class ) );
            }
        } );



        // Inflate the layout for this fragment
        return binding.getRoot ();
    }
}