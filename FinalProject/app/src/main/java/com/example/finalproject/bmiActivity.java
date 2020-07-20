package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class bmiActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        final ImageView Info = findViewById(R.id.imageView);
        final Button CalcForMe_Button = findViewById(R.id.CalculateForMe);
        final Button UseOther_Button = findViewById(R.id.UseOtherValues);
        final LinearLayout OtherValues_Layout= findViewById(R.id.LinearLayout);
        final EditText WeightET = findViewById(R.id.WeightET);
        final EditText HeightET = findViewById(R.id.HeightET);
        final TextView YourBMI = findViewById(R.id.YourBMI);
        final Button Calc_Button = findViewById(R.id.Calc_Button);



        Bundle b = getIntent().getExtras();
       final int Age = Integer.parseInt(b.getString("Age"));
       final double Height =Double.parseDouble(b.getString("Height"));
       final double Weight =Double.parseDouble(b.getString("Weight"));
       final String Gender =b.getString("Gender");



       Calc_Button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double OtherWeight = Double.parseDouble(String.valueOf(WeightET.getText()));
               double OtherHeight = Double.parseDouble(String.valueOf(HeightET.getText()));

               double BMI = OtherWeight /((OtherHeight/100)*(OtherHeight/100));
               DecimalFormat df = new DecimalFormat("#.##");
               String dx=df.format(BMI);
               BMI=Double.valueOf(dx);
               YourBMI.setText("Your BMI is: "+ String.valueOf(BMI));




           }
       });





        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://en.wikipedia.org/wiki/Body_mass_index";

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

                double BMI = Weight /((Height/100)*(Height/100));
                DecimalFormat df = new DecimalFormat("#.##");
                String dx=df.format(BMI);
                BMI=Double.valueOf(dx);
                YourBMI.setText("Your BMI is: "+ String.valueOf(BMI));
                //Toast.makeText(bmiActivity.this, "Your BMI is:  " + BMI, Toast.LENGTH_LONG).show();


            }
        });











    }
}