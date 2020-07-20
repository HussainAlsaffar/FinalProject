package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainPageActivity extends AppCompatActivity {

    String Gender;
   RadioButton Male_Button;
   RadioButton Female_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        final NavigationView MenuLayout = findViewById(R.id.Menu);
        final ImageView OpenMenu = findViewById(R.id.MenuButton);
        final Button CloseMenu = findViewById(R.id.CloseMenu);
        final Button TDEE_Button = findViewById(R.id.TDEE_Button);
        final Button BMR_Button = findViewById(R.id.BMR_Button);
        final Button BMI_Button = findViewById(R.id.BMI_Button);
        final Button IdealWeight_Button = findViewById(R.id.Ideal_Weight_Button);
        final EditText Age_ET = findViewById(R.id.AgeET);
        final EditText Height_ET = findViewById(R.id.HeightET);
        final EditText Weight_ET = findViewById(R.id.WeightET);
        Male_Button = findViewById(R.id.SegmentedButton1);
        Female_Button = findViewById(R.id.SegmentedButton2);


        MenuLayout.setVisibility(View.INVISIBLE);
        OpenMenu.setVisibility(View.VISIBLE);


        OpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuLayout.setVisibility(View.VISIBLE);
                OpenMenu.setVisibility(View.INVISIBLE);

            }
        });


        CloseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuLayout.setVisibility(View.INVISIBLE);
                OpenMenu.setVisibility(View.VISIBLE);

            }
        });


        TDEE_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPageActivity.this, tdeeActivity.class);
                final String Age = Age_ET.getText().toString();
                final String Height = Height_ET.getText().toString();
                final String Weight = Weight_ET.getText().toString();
                i.putExtra("Age",Age);
                i.putExtra("Height",Height);
                i.putExtra("Weight", Weight);
                i.putExtra("Gender",Gender);
                startActivity(i);

            }
        });



        BMR_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPageActivity.this, bmrActivity.class);
                final String Age = Age_ET.getText().toString();
                final String Height = Height_ET.getText().toString();
                final String Weight = Weight_ET.getText().toString();
                i.putExtra("Age",Age);
                i.putExtra("Height",Height);
                i.putExtra("Weight", Weight);
                i.putExtra("Gender",Gender);
                startActivity(i);

            }
        });


        BMI_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPageActivity.this, bmiActivity.class);
                final String Age = Age_ET.getText().toString();
                final String Height = Height_ET.getText().toString();
                final String Weight = Weight_ET.getText().toString();
                i.putExtra("Age",Age);
                i.putExtra("Height",Height);
                i.putExtra("Weight", Weight);
                i.putExtra("Gender",Gender);
                startActivity(i);

            }
        });



        IdealWeight_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPageActivity.this, IdealWeightActivity.class);
                final String Age = Age_ET.getText().toString();
                final String Height = Height_ET.getText().toString();
                final String Weight = Weight_ET.getText().toString();
                i.putExtra("Age",Age);
                i.putExtra("Height",Height);
                i.putExtra("Weight", Weight);
                i.putExtra("Gender",Gender);
                startActivity(i);

            }
        });

        Female_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender="Female";
                //Toast.makeText(MainPageActivity.this, "Gender is "+ Gender, Toast.LENGTH_SHORT).show();
            }
        });

        Male_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender="Male";
                //Toast.makeText(MainPageActivity.this, "Gender is "+ Gender, Toast.LENGTH_SHORT).show();
            }
        });








    }
}