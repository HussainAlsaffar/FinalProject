package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class IdealWeightActivity extends AppCompatActivity {



    RadioButton Male_Button;
    RadioButton Female_Button;

    double OtherHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);


        final ImageView Info = findViewById(R.id.imageView);
        final Button CalcForMe_Button = findViewById(R.id.CalculateForMe);
        final Button UseOther_Button = findViewById(R.id.UseOtherValues);
        final LinearLayout OtherValues_Layout= findViewById(R.id.LinearLayout);

        final EditText HeightET = findViewById(R.id.HeightET);

        final TextView YourIdealWeight = findViewById(R.id.YourIdealWeight);
        final Button Other_Calc_Button = findViewById(R.id.Other_Calc_Button);
        Female_Button = findViewById(R.id.SegmentedButton2);
        Male_Button = findViewById(R.id.SegmentedButton1);

        Bundle b = getIntent().getExtras();

        final double Height =Double.parseDouble(b.getString("Height"));

        final String Gender =b.getString("Gender");
        final String OtherGender = new String();


        Other_Calc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherHeight= Double.parseDouble(String.valueOf(HeightET.getText()));

                if(Male_Button.isChecked()){

                    OtherGender.equals("Male");

                    double OtherIdealBodyWeight =((OtherHeight- 100) - (OtherHeight- 100)*10/100);
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx=df.format(OtherIdealBodyWeight);
                    OtherIdealBodyWeight=Double.valueOf(dx);
                    YourIdealWeight.setText("Your Ideal Weight is: "+ String.valueOf(OtherIdealBodyWeight) + " Kg");

                }else if (Female_Button.isChecked()){

                    OtherGender.equals("Female");

                    double OtherIdealBodyWeight =(OtherHeight - 100) - ((OtherHeight - 100) * 15/100);
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx=df.format(OtherIdealBodyWeight);
                    OtherIdealBodyWeight=Double.valueOf(dx);
                    YourIdealWeight.setText("Your Ideal Weight is: "+ String.valueOf(OtherIdealBodyWeight) + " Kg");
                }




            }
        });




        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://en.wikipedia.org/wiki/Human_body_weight#Ideal_body_weight";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        OtherValues_Layout.setVisibility(View.INVISIBLE);

        UseOther_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherValues_Layout.setVisibility(View.VISIBLE);

            }
        });


        CalcForMe_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OtherValues_Layout.setVisibility(View.INVISIBLE);

                if(Gender.equals("Male")){
                    double IdealBodyWeight =(Height  - 100) - ((Height  - 100) * 10/100);
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx=df.format(IdealBodyWeight);
                    IdealBodyWeight=Double.valueOf(dx);
                    YourIdealWeight.setText("Your Ideal Weight is: "+ String.valueOf(IdealBodyWeight) + " Kg");

                }else if (Gender.equals("Female")){
                    double IdealBodyWeight = (Height - 100) - ((Height - 100) * 15/100);
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx=df.format(IdealBodyWeight);
                    IdealBodyWeight=Double.valueOf(dx);
                    YourIdealWeight.setText("Your Ideal Weight is: "+ String.valueOf(IdealBodyWeight) + " Kg");
                }



            }
        });






    }
}