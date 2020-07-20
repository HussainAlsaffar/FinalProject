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

public class bmrActivity extends AppCompatActivity {

    int Special;
    int OtherSpecial;
    RadioButton Male_Button;
    RadioButton Female_Button;
    double OtherWeight;
     double OtherHeight;
     double OtherAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);


        final ImageView Info = findViewById(R.id.imageView);
        final Button CalcForMe_Button = findViewById(R.id.CalculateForMe);
        final Button UseOther_Button = findViewById(R.id.UseOtherValues);
        final LinearLayout OtherValues_Layout= findViewById(R.id.LinearLayout);
        final EditText WeightET = findViewById(R.id.WeightET);
        final EditText HeightET = findViewById(R.id.HeightET);
        final EditText AgeET = findViewById(R.id.AgeET);
        final TextView YourBMR = findViewById(R.id.YourBMR);
        final Button Other_Calc_Button = findViewById(R.id.Other_Calc_Button);
        Female_Button = findViewById(R.id.SegmentedButton2);
        Male_Button = findViewById(R.id.SegmentedButton1);

        Bundle b = getIntent().getExtras();
        final int Age = Integer.parseInt(b.getString("Age"));
        final double Height =Double.parseDouble(b.getString("Height"));
        final double Weight =Double.parseDouble(b.getString("Weight"));
        final String Gender =b.getString("Gender");
        final String OtherGender = new String();


       Other_Calc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherWeight= Double.parseDouble(String.valueOf(WeightET.getText()));
                 OtherHeight= Double.parseDouble(String.valueOf(HeightET.getText()));
                 OtherAge = Double.parseDouble(String.valueOf(AgeET.getText()));

                if(Male_Button.isChecked()){
                    OtherGender.equals("Male");
                    OtherSpecial = 5;
                }else if (Female_Button.isChecked()){
                    OtherGender.equals("Female");
                    OtherSpecial = -161;
                }


                double BMR = 10 * OtherWeight+ 6.25 * OtherHeight - 5 * OtherAge + OtherSpecial;
                DecimalFormat df = new DecimalFormat("#.##");
                String dx=df.format(BMR);
                BMR=Double.valueOf(dx);
                 YourBMR.setText("Your BMR is: "+ String.valueOf(BMR) + " Kcal/Day");

            }
        });




        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://en.wikipedia.org/wiki/Basal_metabolic_rate";

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
                    Special =5;
                }else if(Gender.equals("Female"))
                     {
                    Special =-161;
                }



                double BMR = 10 * Weight+ 6.25 * Height - 5 * Age + Special;
                DecimalFormat df = new DecimalFormat("#.##");
                String dx=df.format(BMR);
                BMR=Double.valueOf(dx);
                YourBMR.setText("Your BMR is: "+ String.valueOf(BMR)+ " Kcal/Day");



            }
        });






    }
}