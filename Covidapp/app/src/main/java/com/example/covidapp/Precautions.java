package com.example.covidapp;

public class Precautions extends CovidInfo{

    String precautions= " Wear mask\n\n Clean Hands\n\n KEEAL Bacteria\n\n Dont take finals on campus";

    public Precautions() {
    }

    @Override
    public String ShowDetails() {
        return precautions;
    }
}
