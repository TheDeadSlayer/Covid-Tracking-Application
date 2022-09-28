package com.example.covidapp;

public class Suspected extends Person{

    Instructions x = new Instructions();


    public Suspected() {
    }

    public Suspected(String ID, String name, String location, String phoneNum, int age) {
        super(ID, name, location, phoneNum, age);
    }

    public String UIColor()
    {
        return "GREY";
    }

    @Override
    public String Instruct() {
        if (IsVaccinated==true)
            return Name+" Is Vaccinated"+x.ChooseInstruction("SuspectedVac");
        else
            return Name+" Is not Vaccinated"+x.ChooseInstruction("Suspected");
    }
}

