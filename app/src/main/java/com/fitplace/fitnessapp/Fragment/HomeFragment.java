package com.fitplace.fitnessapp.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.databinding.FragmentHomeBinding;
import com.fitplace.fitnessapp.FmGYM.FmGym;
import com.fitplace.fitnessapp.Gain.Body_Type;
import com.fitplace.fitnessapp.Lose.BMI_Calculater;
import com.fitplace.fitnessapp.Lose.CardAndWhats;
import com.fitplace.fitnessapp.Lose.LossWeight;
import com.fitplace.fitnessapp.Lose.Tips;
import com.fitplace.fitnessapp.MainActivity;
import com.fitplace.fitnessapp.MenuItem.MyContact;
import com.fitplace.fitnessapp.Neutrition.NutritionFacts;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

    }

  FragmentHomeBinding binding;

    BottomSheetDialog sheetDialog;
    TextView cardAdd, share, contact;
    ActionBarDrawerToggle toggle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate ( getLayoutInflater () );




        binding.GainMuscle.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), Body_Type.class) );
            }
        } );


        binding.loseWeight.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (getContext (), LossWeight.class) );
            }
        } );


              binding.imageView2.setOnClickListener ( new View.OnClickListener () {
                  @Override
                  public void onClick(View v) {
                      toggLEbarbotton ();
                  }
              } );



              binding.nuritions.setOnClickListener ( new View.OnClickListener () {
                  @Override
                  public void onClick(View v) {
                      startActivity ( new Intent (getContext (), NutritionFacts.class ) );
                  }
              } );


              binding.nfgym.setOnClickListener ( new View.OnClickListener () {
                  @Override
                  public void onClick(View v) {
                      startActivity ( new Intent (getContext (), FmGym.class ) );
                  }
              } );


              binding.BMI.setOnClickListener ( new View.OnClickListener () {
                  @Override
                  public void onClick(View v) {
                      startActivity ( new Intent (getContext (), BMI_Calculater.class ) );
                  }
              } );
              binding.tips.setOnClickListener ( new View.OnClickListener () {
                  @Override
                  public void onClick(View v) {
                      startActivity ( new Intent (getContext (), Tips.class ) );
                  }
              } );

              binding.Brainwaver.setOnClickListener ( new View.OnClickListener () {
                  @Override
                  public void onClick(View v) {


                      BrainWaver ();

                  }
              } );

        return binding.getRoot ();
        //inflater.inflate ( R.layout.fragment_home, container, false );
    }


    //shit logout share

    public void toggLEbarbotton(){

        View view = getLayoutInflater ().inflate ( R.layout.logoutsheet_item, null);

        LinearLayout call = view.findViewById ( R.id.logout_sheetID );
        call.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        } );

        BottomSheetDialog dialog = new BottomSheetDialog ( getActivity () );
        dialog.setContentView ( view );
        dialog.show ();

    }

    //Brain wave
    public void BrainWaver(){

        View view = getLayoutInflater ().inflate ( R.layout.loss_ten_sheet, null );

        LinearLayout call = view.findViewById ( R.id.lossTen );
        call.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        } );

        BottomSheetDialog dialog = new BottomSheetDialog ( getActivity () );
        dialog.setContentView ( view );
        dialog.show ();
    }



}


