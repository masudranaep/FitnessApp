package com.fitplace.fitnessapp.DayFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fitnessapp.R;
import com.fitplace.fitnessapp.Time.TimeWorkout;


public class FragmentGym_7 extends Fragment {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;


    public FragmentGym_7() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View v =  inflater.inflate ( R.layout.fragment_gym_7, container, false );

        btn1  = v.findViewById ( R.id.walkingspot );
        btn2 = v.findViewById ( R.id.jogging );
        btn3 = v.findViewById ( R.id.sidejump );
        btn4 = v.findViewById ( R.id.wallpushupss );
        btn5 = v.findViewById ( R.id.degreejump );
        btn6 = v.findViewById ( R.id.widepushUps );
        btn7 = v.findViewById ( R.id.Alternate );

        btn1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext (), TimeWorkout.class );
                startActivity ( intent );
            }
        } );
        btn2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext (), TimeWorkout.class );
                startActivity ( intent );
            }
        } );
        btn3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext (), TimeWorkout.class );
                startActivity ( intent );
            }
        } );
        btn4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext (), TimeWorkout.class );
                startActivity ( intent );
            }
        } );
        btn5.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext (), TimeWorkout.class );
                startActivity ( intent );
            }
        } );
        btn6.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext (), TimeWorkout.class );
                startActivity ( intent );
            }
        } );
        btn7.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getContext (), TimeWorkout.class );
                startActivity ( intent );
            }
        } );

        return  v;
    }
}