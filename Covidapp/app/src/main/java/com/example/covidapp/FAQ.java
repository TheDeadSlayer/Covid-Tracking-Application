package com.example.covidapp;

public class FAQ extends CovidInfo{

    String QNA="Corona bad ?\nAns: Yes\n\nTake Precautions?\n Ans: Yes\n\nMake Finals Online?\n Ans:Yes ";

    public FAQ() {
    }

    @Override
    public String ShowDetails() {
        return QNA;
    }


}
