package com.fitplace.fitnessapp.DayFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fitnessapp.R;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class FragmentDiet_1 extends Fragment {

    public FragmentDiet_1() {
        // Required empty public constructor


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate ( R.layout.fragment_diet_1, container, false );



        return rootView;

    }
}