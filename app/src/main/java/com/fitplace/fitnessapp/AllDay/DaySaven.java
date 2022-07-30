package com.fitplace.fitnessapp.AllDay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.fitplace.fitnessapp.DayFragment.FragmentDiet_7;
import com.fitplace.fitnessapp.DayFragment.FragmentGym_7;
import com.example.fitnessapp.R;

public class DaySaven extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_day_saven );

        recyclerView = findViewById ( R.id.dietandworkout );
        getSupportFragmentManager ().beginTransaction ().replace ( R.id.l2, new FragmentDiet_7 () ).commit ();
    }

    public void workout(View view) {

        Fragment fragment = null;
        switch (view.getId ()){
            case  R.id.dietone:
                fragment = new FragmentDiet_7 ();
                break;
            case R.id.workoutone:
                fragment = new FragmentGym_7 ();
                break;
        }
        FragmentManager fm  = getSupportFragmentManager ();
        FragmentTransaction ft = fm.beginTransaction ();
        ft.replace ( R.id.l2, fragment );
        ft.commit ();

    }
}