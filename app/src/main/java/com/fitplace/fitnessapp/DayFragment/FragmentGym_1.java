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

public class FragmentGym_1 extends Fragment {
Button btn1, btn2, btn3, btn4, btn5;

    public FragmentGym_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate ( R.layout.fragment_gym_1, container, false );
        btn1  = v.findViewById ( R.id.walkingspot );
        btn2 = v.findViewById ( R.id.jogging );
        btn3 = v.findViewById ( R.id.sidejump );
        btn4 = v.findViewById ( R.id.wallpushupss );
        btn5 = v.findViewById ( R.id.degreejump );

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


        return  v;
    }
}