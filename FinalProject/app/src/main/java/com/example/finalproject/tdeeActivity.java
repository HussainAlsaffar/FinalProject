package com.example.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class tdeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    int OtherSpecial;
    RadioButton Male_Button;
    RadioButton Female_Button;
    double OtherWeight;
    double OtherHeight;
    double OtherAge;

    private Spinner spinner;
    private static final String[] ActivityLevels = {"Sedentary", "Lightly Active", "Active", "Very Active"};
    String ActivityLevelString = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdee);

        spinner = (Spinner) findViewById(R.id.spinner1);


        final ImageView Info = findViewById(R.id.imageView);
        final Button UseOther_Button = findViewById(R.id.UseOtherValues);
        final LinearLayout OtherValues_Layout = findViewById(R.id.LinearLayout);
        final EditText WeightET = findViewById(R.id.WeightET);
        final EditText HeightET = findViewById(R.id.HeightET);
        final EditText AgeET = findViewById(R.id.AgeET);
        final TextView YourTDEE = findViewById(R.id.YourTDEE);
        final Button Other_Calc_Button = findViewById(R.id.Other_Calc_Button);
        Female_Button = findViewById(R.id.SegmentedButton2);
        Male_Button = findViewById(R.id.SegmentedButton1);



        final String OtherGender = new String();


        Other_Calc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OtherWeight = Double.parseDouble(String.valueOf(WeightET.getText()));
                OtherHeight = Double.parseDouble(String.valueOf(HeightET.getText()));
                OtherAge = Double.parseDouble(String.valueOf(AgeET.getText()));

                if (Male_Button.isChecked()) {
                    OtherGender.equals("Male");
                    OtherSpecial = 5;
                } else if (Female_Button.isChecked()) {
                    OtherGender.equals("Female");
                    OtherSpecial = -161;
                }


                final double formula = 10 * OtherWeight + 6.25 * OtherHeight - 5.0 * OtherAge + OtherSpecial;

                if (ActivityLevelString.equals("Sedentary")) {
                    double TDEE = (formula) * 1.2;
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx = df.format(TDEE);
                    TDEE = Double.valueOf(dx);
                    YourTDEE.setText("Your TDEE is: " + String.valueOf(TDEE) + " Kcal/Day");



                } else if (ActivityLevelString.equals("Lightly Active")) {
                    double TDEE = (formula) * 1.375;
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx = df.format(TDEE);
                    TDEE = Double.valueOf(dx);
                    YourTDEE.setText("Your TDEE is: " + String.valueOf(TDEE) + " Kcal/Day");



                } else if (ActivityLevelString.equals("Active")) {
                    double TDEE = (formula) * 1.55;
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx = df.format(TDEE);
                    TDEE = Double.valueOf(dx);
                    YourTDEE.setText("Your TDEE is: " + String.valueOf(TDEE) + " Kcal/Day");


                } else if (ActivityLevelString.equals("Very Active")) {
                    double TDEE = (formula) * 1.8;
                    DecimalFormat df = new DecimalFormat("#.##");
                    String dx = df.format(TDEE);
                    TDEE = Double.valueOf(dx);
                    YourTDEE.setText("Your TDEE is: " + String.valueOf(TDEE) + " Kcal/Day");




                }




            }
        });


        OtherValues_Layout.setVisibility(View.INVISIBLE);

        UseOther_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OtherValues_Layout.setVisibility(View.VISIBLE);

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


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(tdeeActivity.this,
                android.R.layout.simple_spinner_item, ActivityLevels);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                ActivityLevelString = ("Sedentary");
                break;
            case 1:
                ActivityLevelString = ("Lightly Active");
                break;
            case 2:
                ActivityLevelString = ("Active");
                break;
            case 3:
                ActivityLevelString = ("Very Active");
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


}