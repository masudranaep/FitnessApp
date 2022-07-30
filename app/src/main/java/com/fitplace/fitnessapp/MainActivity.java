package com.fitplace.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.fitnessapp.R;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fitnessapp.databinding.ActivityMainBinding;
import com.fitplace.fitnessapp.Fragment.HomeFragment;
import com.fitplace.fitnessapp.Fragment.LavelFragment;
import com.fitplace.fitnessapp.Fragment.OnlineFragment;
import com.fitplace.fitnessapp.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {




//    @SuppressLint("WrongViewCast")
    private BottomNavigationView bottomNavigationView;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );




        bottomNavigationView = (BottomNavigationView) findViewById ( R.id.bottnNavigationView);
        navController = Navigation.findNavController ( this, R.id.frame_layout );


        NavigationUI.setupWithNavController ( bottomNavigationView, navController );



//        FragmentTransaction transaction = getSupportFragmentManager ().beginTransaction ();
//        transaction.replace ( R.id.content, new HomeFragment () );
//        transaction.commit ();
//
//        binding.bottomnavigation.setOnNavigationItemSelectedListener ( new BottomNavigationView.OnNavigationItemSelectedListener () {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                FragmentTransaction transaction = getSupportFragmentManager ().beginTransaction ();
//
//                switch (item.getItemId ()) {
//                    case R.id.home:
//                        transaction.replace ( R.id.content, new HomeFragment () );
//                        transaction.commit ();
//                        break;
//                    case R.id.rank:
//                        transaction.replace ( R.id.content, new OnlineFragment () );
//
//                        transaction.commit ();
//
//
//
//                        break;
//                    case R.id.wallet:
//                        transaction.replace ( R.id.content, new LavelFragment ());
//                        transaction.commit ();
//                        break;
//                    case R.id.profile:
//
//                        transaction.replace ( R.id.content, new ProfileFragment () );
//                        transaction.commit ();
//                        break;
//
//
//                }
//                return true;
//            }
//        } );


    }


}

