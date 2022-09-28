package com.example.covidapp;

import java.util.Date;

public class Quarantined extends Person{

    Instructions x = new Instructions();
    String ArrivedFrom;
    Date DateOfArrival;

    public Quarantined() {
    }

    public Quarantined(String ID, String name, String location, String phoneNum, int age) {
        super(ID, name, location, phoneNum, age);
    }

    public Quarantined(String ID, String name, String location, String phoneNum, int age, String arrivedFrom) {
        super(ID, name, location, phoneNum, age);
        ArrivedFrom = arrivedFrom;
    }

    public void setArrivedFrom(String arrivedFrom) {
        ArrivedFrom = arrivedFrom;
    }

    public String getArrivedFrom() {
        return ArrivedFrom;
    }

    public String UIColor()
    {
        return "YELLOW";
    }
    @Override
    public String Instruct() {

        if (IsVaccinated==true)
            return Name+" Is Vaccinated"+x.ChooseInstruction("QuarantineVac");
        else
            return Name+" Is not Vaccinated"+x.ChooseInstruction("Quarantine");
    }
}