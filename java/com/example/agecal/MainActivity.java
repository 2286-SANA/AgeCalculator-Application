package com.example.agecal;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {



      EditText mYear;
      Button mCal;
      TextView mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        mYear = findViewById(R.id.yrEdit);
        mCal  = findViewById(R.id.Calbtn);
        mAge = findViewById(R.id.textEdit);

        mCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userDOB= mYear.getText().toString().trim();
                int year = Calendar.getInstance().get(Calendar.YEAR);

                if(userDOB.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter a Year", Toast.LENGTH_SHORT).show();
                }
                else if(userDOB.compareTo(String.valueOf(year))>0){

                    Toast.makeText(MainActivity.this, "Year should be less than year", Toast.LENGTH_SHORT).show();
                }
                else{

                    int myAge = year - Integer.parseInt(userDOB);
                    mAge.setText("Your age is " +myAge+ " years.");

                }
            }
        });
    }
}