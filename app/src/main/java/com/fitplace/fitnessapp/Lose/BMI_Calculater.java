package com.fitplace.fitnessapp.Lose;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fitplace.fitnessapp.MainActivity;
import com.example.fitnessapp.R;

public class BMI_Calculater extends AppCompatActivity {

    Button bmicalculater;
    TextView mcurrentheight;
    TextView mcurrentage, mcurrentweight;
    ImageView mincrementage, mincrementweight, mdecrentweight, mdecrementage;
    SeekBar seekbarheight;
    RelativeLayout mmale, mfemale;

    int intweight = 55;
    int intage = 22;
    int currentprogreess;
    String mintprogress = "170";
    String typeofuser = "0";
    String weight2= "55";
    String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_bmi_calculater );



            bmicalculater = findViewById ( R.id.bmicalButton );
            mcurrentheight = findViewById ( R.id.currentheight );
            mcurrentage = findViewById ( R.id.currentage );
            mcurrentweight = findViewById ( R.id.currentweight );
            mincrementage = findViewById ( R.id.minusage );
            mdecrementage = findViewById ( R.id.plusage );
            mincrementweight = findViewById ( R.id.minusweight );
            mdecrentweight = findViewById ( R.id.plusweight );
            seekbarheight = findViewById (R.id.seekbar);
            mmale = findViewById ( R.id.male );
            mfemale = findViewById ( R.id.femal );


            //male and female backgraund

            mmale.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    mmale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.maleorfemalefoucash) );
                    mfemale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.femalefocash ) );
                    typeofuser = "Male";
                }
            } );

            mfemale.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    mfemale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.maleorfemalefoucash) );
                    mmale.setBackground ( ContextCompat.getDrawable ( getApplicationContext (), R.drawable.femalefocash ) );
                    typeofuser = "Female";
                }
            } );

//seekbar
            seekbarheight.setMax ( 300 );
            seekbarheight.setProgress ( 170 );
            seekbarheight.setOnSeekBarChangeListener ( new SeekBar.OnSeekBarChangeListener () {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    currentprogreess = progress;
                    mintprogress = String.valueOf ( currentprogreess );
                    mcurrentheight.setText ( mintprogress );


                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            } );

            // plus minus

            mincrementage.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    intage = intage -1;
                    age2 = String.valueOf ( intage );
                    mcurrentage.setText ( age2 );
                }
            } );

            mdecrementage.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    intage = intage +1;
                    age2 = String.valueOf ( intage );
                    mcurrentage.setText ( age2 );
                }
            } );


            mincrementweight.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    intweight = intweight -1;
                    weight2 = String.valueOf ( intweight );
                    mcurrentweight.setText ( weight2 );
                }
            } );

            mdecrentweight.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    intweight = intweight +1;
                    weight2 = String.valueOf ( intweight );
                    mcurrentweight.setText ( weight2 );
                }
            } );
            

//calculater your button


            bmicalculater.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    if(typeofuser.equals ( "0" )){

                        Toast.makeText ( getApplicationContext (), "Select Your Gender First", Toast.LENGTH_LONG ).show ();
                    }else if(mintprogress.equals ( "0" )){

                        Toast.makeText ( getApplicationContext (), "Select Your Height First", Toast.LENGTH_LONG ).show ();

                    }else if(intage == 0 || intage < 0){

                        Toast.makeText ( getApplicationContext (), "Age Is Incrrect", Toast.LENGTH_LONG ).show ();

                    }else  if(intweight == 0 || intweight < 0){

                        Toast.makeText ( getApplicationContext (), "Weight Is Incorrect", Toast.LENGTH_LONG ).show ();
                    }else {

                        Intent intent = new Intent ( BMI_Calculater.this, BMI_Result.class );
                        intent.putExtra ( "gender", typeofuser );
                        intent.putExtra ( "height", mintprogress );
                        intent.putExtra ( "weight", weight2 );
                        intent.putExtra ( "age", age2 );

                        startActivity ( intent );

                    }
                }
            } );
        }

    public void Backpass(View view) {
        Intent intent = new Intent ( BMI_Calculater.this, MainActivity.class);
        startActivity ( intent );
    }
}
