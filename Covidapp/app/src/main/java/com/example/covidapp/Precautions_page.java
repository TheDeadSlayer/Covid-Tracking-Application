package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Precautions_page extends AppCompatActivity {

    Precautions prec= new Precautions();
    TextView P;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions_page);

        P= (TextView)findViewById(R.id.txt_Precautions);
        P.setText(prec.ShowDetails());
    }
}