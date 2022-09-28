package com.example.covidapp;

public class Person {
    String ID;
    String Name;
    int Age;
    String Location;
    String PhoneNum;
    Boolean Verify;
    protected Boolean IsVaccinated;

    String VaccineName="0";
    int DoseNum=0;
    int DaysTillNextDoes;
    public String FirstDose;
    public String SecondDose;

    String Institution;
    int CT;
    String Result;
    boolean FitForTravel=false;


    public Person()
    {

    }
    public Person(String ID, String name, String location, String phoneNum,int age) {
        this.ID = ID;
        Name = name;
        Location = location;
        PhoneNum = phoneNum;
        Age=age;
    }

    public void setID(String ID) {

        if(ID.length()==2)
            this.ID = ID;
    }

    public void setPhoneNum(String phoneNum) {

        if(phoneNum.length()==2)
            PhoneNum = phoneNum;
    }

    public void setAge(int age) {

        if(age>0)
            Age = age;
    }
    public void setVaccinated()
    {
        if (getAge()<18)
            IsVaccinated = false;
    }


    public int getAge() {
        return Age;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public Boolean getVerify() {
        return Verify;
    }

    public void setVerify(Boolean verify) {
        Verify = verify;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void SendVerMsg()
    {}

    public String Instruct()
    {
        return null;
    }


    public Boolean ShowVStamp()
    {
        return IsVaccinated;
    }

    public void setVaccineName(String vaccineName) {
        if( vaccineName.equals("Pfizer") ||vaccineName.equals("Moderna")||vaccineName.equals("BIBP")||vaccineName.equals("AstraZeneca")||vaccineName.equals("Johnson"))
            VaccineName = vaccineName;
    }
    public String getVaccineName() {
        return VaccineName;
    }

    public void setDoseNum(int doseNum) {

        if(doseNum>0&&doseNum<3)
            DoseNum = doseNum;
    }

    public int getDoseNum() {
        return DoseNum;
    }


    public void VacInfo()
    {

        switch (VaccineName)
        {
            case "Pfizer":DaysTillNextDoes=21; DoseNum= 2;break;
            case "Moderna": DaysTillNextDoes=14;DoseNum=2;break;
            case "BIBP":DaysTillNextDoes=30;DoseNum=2;break;
            case "AstraZeneca":DaysTillNextDoes=90;DoseNum=2;break;
            case "Johnson":DaysTillNextDoes=0;DoseNum=1;break;
            default: DoseNum=0;break;
        }
    }

    public String getFirstDose() {
        return FirstDose;
    }

    public String getSecondDose() {
        return SecondDose;
    }

    public void SecondDoseDate()
    {

    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    public void setResult(String result) {
        Result = result;
    }

    public void setFitForTravel(boolean fitForTravel) {
        FitForTravel = fitForTravel;
    }

    public int getCT() {
        return CT;
    }

    public void setCT(int CT) {

        if(CT>=0&&CT<=100)
            this.CT = CT;
    }

    public String Res(/*Vaccinated x,Boolean Vac*/)
    {
        if (CT==0) {
            Result = "Negative";
        }
        else if(CT>0&&CT<=30) {
            Result = "Positive";
        }

        else {
            Result="Reactive";
        }

        return  Result;

    }

    public Boolean Travel()
    {
        if(Result=="Negative")
            FitForTravel=true;
        else
            FitForTravel=false;

        return FitForTravel;
    }

    public void setFirstDose(String firstDose) {
        FirstDose = firstDose;
    }

    public Boolean getVaccinated() {
        return IsVaccinated;
    }

    public String getInstitution() {
        return Institution;
    }

    public void setSecondDose(String secondDose) {
        SecondDose = secondDose;
    }
}
