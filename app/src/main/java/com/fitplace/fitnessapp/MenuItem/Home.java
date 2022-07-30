package com.fitplace.fitnessapp.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fitplace.fitnessapp.MainActivity;
import com.example.fitnessapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Home extends AppCompatActivity {
DrawerLayout drawerLayout;
ImageView logoutAdd;
BottomSheetDialog sheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );
        drawerLayout =findViewById ( R.id.drawer_layout );

        logoutAdd = findViewById ( R.id.logoutfin );
    }

//    public  void ClickMenu(View view){
//        MainActivity.openDrawer(drawerLayout);
//
//    }
//    public void ClickLogo(View view){
//        MainActivity.closeDrawer ( drawerLayout );
//    }
//    public void ClickHome(View view){
//        MainActivity.redirectActivity ( this, MainActivity.class );
//    }
//    public void ClickDeshboard(View view){
//        recreate ();
//    }
//    public  void ClickDeshAboutUS(View view){
//        MainActivity.redirectActivity ( this, AboutUs.class );
//    }
//    public  void ClickLogout(View view){
//        MainActivity.Logout ( this );
//    }
//    protected void onPause() {
//
//        super.onPause ();
//        MainActivity.closeDrawer ( drawerLayout );
//    }
//
//
//    public  void logoutosheet(View view){
//
//
//        logoutAdd.setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//                sheetDialog = new BottomSheetDialog ( Home.this, R.style.BottomSheetDialogTheme );
//                View view = LayoutInflater.from ( Home.this ).inflate ( R.layout.logoutsheet_item,(LinearLayout) findViewById ( R.id.logout_sheetID ) );
//                sheetDialog.setContentView ( view );
//                sheetDialog.show ();
//            }
//        } );
//
//
//    }
}