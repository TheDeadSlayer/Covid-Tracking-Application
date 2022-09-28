package com.example.covidapp;

public class Positive extends Person {

    Instructions inst = new Instructions();
    String QuarantineLocation;
    int SeverityLevel;
    int Contacts;

    public Positive() {
    }

    public Positive(String ID, String name, String location, String phoneNum, int age) {
        super(ID, name, location, phoneNum, age);
    }

    public Positive(String ID, String name, String location, String phoneNum, int age, int severityLevel, int contacts) {
        super(ID, name, location, phoneNum, age);
        SeverityLevel = severityLevel;
        Contacts = contacts;
    }

    public void setSeverityLevel(int severityLevel) {
        SeverityLevel = severityLevel;
    }

    public void setContacts(int contacts) {
        Contacts = contacts;
    }

    public int getSeverityLevel() {
        return SeverityLevel;
    }

    public int getContacts() {
        return Contacts;
    }

    public String SetLocation() {
        switch (SeverityLevel) {
            case 1:
                QuarantineLocation = "Home Quarantine";
                break;
            case 2:
                QuarantineLocation = "Hotel Quarantine";
                break;
            case 3:
                QuarantineLocation = "Hospital Quarantine"; break;
            default:
                break;
        }
        return QuarantineLocation;
    }


    public String UIColor()
    {
        return "RED";
    }

    @Override
    public String Instruct() {

        if (IsVaccinated )
            return Name + " Is Vaccinated" + inst.ChooseInstruction("PositiveVac");
        else
            return Name + " Is not Vaccinated" + inst.ChooseInstruction("Positive");
    }
}