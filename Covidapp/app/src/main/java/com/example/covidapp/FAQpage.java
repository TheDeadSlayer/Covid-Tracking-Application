package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FAQpage extends AppCompatActivity {

    FAQ Qna= new FAQ();

    TextView faq1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqpage);
        faq1=(TextView) findViewById(R.id.txt_FAQ);
        faq1.setText(Qna.ShowDetails());

    }



}
