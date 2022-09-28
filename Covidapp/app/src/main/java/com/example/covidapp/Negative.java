package com.example.covidapp;

public class Negative extends Person{
    Instructions x = new Instructions();

    public Negative() {
    }

    public Negative(String ID, String name, String location, String phoneNum, int age) {
        super(ID, name, location, phoneNum, age);
    }

    public String UIColor()
    {
        return "GREEN";
    }
    @Override
    public String Instruct()
    {
        if (IsVaccinated==true)
            return Name+" Is Vaccinated"+x.ChooseInstruction("NegativeVac");
        else
            return Name+" Is not Vaccinated"+x.ChooseInstruction("Negative");
    }
}