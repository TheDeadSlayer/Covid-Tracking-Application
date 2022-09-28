package com.example.covidapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.net.IDN;

public class SharedPrefManager {
    private static SharedPrefManager instance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "mysharedpreft12";
    private static final String Key_ID = "ID";
    private static final String Key_Name = "NameP";
    private static final String Key_Age = "Age";
    private static final String Key_Location = "Location";
    private static final String Key_PhoneNumber = "PhoneNumber";
    private static final String Key_Institution = "Institution";
    private static final String Key_CT = "CT";
    private static final String Key_VacStatus = "VaccinationStatus";
    private static final String Key_VacName = "VaccineName";
    private static final String Key_FDose = "FirstDoseDate";
    private static final String Key_SDose = "SecondDoseDate";
    private static final String Key_Type = "TypeS";
    private static final String Key_Slevel = "SeverityLevel";
    private static final String Key_Contacts = "Contacts";
    private static final String Key_ArrivedF = "ArrivedFrom";
    private static final String Key_Verify = "Verified";


    private SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefManager(context);
        }
        return instance;
    }

    public Boolean userLogin(String ID, String Name, int Age, String Location, String PhoneNumber, String Institution, int CT, String VacStatus, String VacName, String FirstDose, String SecondDose, String Type, int SLevel, int Contacts, String ArrivedFrom, String Verify) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Key_ID, ID);
        editor.putString(Key_Name, Name);
        editor.putInt(Key_Age, Age);
        editor.putString(Key_Location, Location);
        editor.putString(Key_PhoneNumber, PhoneNumber);
        editor.putString(Key_Institution, Institution);
        editor.putInt(Key_CT, CT);
        editor.putString(Key_VacStatus,VacStatus);
        editor.putString(Key_VacName, VacName);
        editor.putString(Key_FDose, FirstDose);
        editor.putString(Key_SDose, SecondDose);
        editor.putString(Key_Type,Type);
        editor.putInt(Key_Slevel, SLevel);
        editor.putInt(Key_Contacts, Contacts);
        editor.putString(Key_ArrivedF, ArrivedFrom);
        editor.putString(Key_Verify, Verify);

        editor.apply();
        return true;
    }

    public Boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        if (sharedPreferences.getString(Key_ID, null) != null) {
            return true;
        }
        return false;
    }

    public boolean Logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();
        return true;

    }

    static public void getclass()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);


        String type= sharedPreferences.getString(Key_Type,null);

        switch (type)
        {
            case ("Positive"):
                Positive Ptemp= new Positive();
                login.person =(Positive) Ptemp;
                Ptemp.setSeverityLevel(sharedPreferences.getInt(Key_Slevel,0));
                Ptemp.setContacts(sharedPreferences.getInt(Key_Contacts,0));

                login.person=Ptemp;
                break;

            case ("Negative"):

                Negative Ntemp= new Negative();
                login.person =(Negative) Ntemp;
                login.person=Ntemp;
                break;

            case ("Quarantined") :
                Quarantined Qtemp= new Quarantined();
                login.person =(Quarantined) Qtemp;

                Qtemp.setArrivedFrom(sharedPreferences.getString(Key_ArrivedF,null));
                System.out.println(Qtemp.getArrivedFrom());
                login.person=Qtemp;
                break;

            case ("Suspected"):
                Suspected Stemp= new Suspected();
                login.person =(Suspected) Stemp;
                login.person=Stemp;
                break;
        }

        String Verf= sharedPreferences.getString(Key_VacStatus,null);

        if (Verf.equals("Yes"))
            login.person.Verify=true;
        else
            login.person.Verify=false;

        login.person.setID(sharedPreferences.getString(Key_ID,null));
        login.person.setName(sharedPreferences.getString(Key_Name,"lol"));
        login.person.setAge(sharedPreferences.getInt(Key_Age,0));
        login.person.setLocation(sharedPreferences.getString(Key_Location,null));
        login.person.setPhoneNum(sharedPreferences.getString(Key_PhoneNumber,null));
        login.person.setInstitution(sharedPreferences.getString(Key_Institution,null));
        login.person.setCT(sharedPreferences.getInt(Key_CT,0));

        String Vac= sharedPreferences.getString(Key_VacStatus,"No").toString();


        if (Vac.equals("Yes"))
            login.person.IsVaccinated=true;
        else
            login.person.IsVaccinated=false;

        login.person.setVaccineName(sharedPreferences.getString(Key_VacName,null));
        login.person.setFirstDose(sharedPreferences.getString(Key_FDose,null));
        login.person.setSecondDose(sharedPreferences.getString(Key_SDose,null));

    }

    public void getID()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setID(sharedPreferences.getString(Key_ID,null));

    }
    public String getName()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setName(sharedPreferences.getString(Key_Name,"lol"));
        return (sharedPreferences.getString(Key_Name,"lol"));
    }

    public void getAge()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setAge(sharedPreferences.getInt(Key_Age,0));
    }

    public void getLocation()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setLocation(sharedPreferences.getString(Key_Location,null));
    }

    public void getPhoneNum()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setPhoneNum(sharedPreferences.getString(Key_PhoneNumber,null));
    }

    public void getInstitution()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setInstitution(sharedPreferences.getString(Key_Institution,null));
    }

    public void getCT()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setCT(sharedPreferences.getInt(Key_CT,0));
    }

    public Boolean getVacStatus()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String Vac= sharedPreferences.getString(Key_VacStatus,null);

        if (Vac.equals("Yes")) {
            login.person.IsVaccinated = true;
            return true;
        }
        else {
             login.person.IsVaccinated = false;
                return false;

             }
    }

    public void getVacName()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setVaccineName(sharedPreferences.getString(Key_VacName,null));
    }

    public void getFDose()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setFirstDose(sharedPreferences.getString(Key_FDose,null));
    }

    public void getSDose()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        login.person.setSecondDose(sharedPreferences.getString(Key_SDose,null));
    }

    public void getType()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String type= sharedPreferences.getString(Key_Type,null);

        switch (type)
        {
            case ("Positive"):
                Positive Ptemp= new Positive();
                login.person =(Positive) Ptemp;
                Ptemp.setSeverityLevel(sharedPreferences.getInt(Key_Slevel,0));
                Ptemp.setContacts(sharedPreferences.getInt(Key_Contacts,0));

                login.person=Ptemp;
                break;

            case ("Negative"):

                Negative Ntemp= new Negative();
                login.person =(Negative) Ntemp;
                login.person=Ntemp;
                break;

            case ("Quarantined") :
                Quarantined Qtemp= new Quarantined();
                login.person =(Quarantined) Qtemp;

                Qtemp.setArrivedFrom(sharedPreferences.getString(Key_ArrivedF,null));
                System.out.println(Qtemp.getArrivedFrom());
                login.person=Qtemp;
                break;

            case ("Suspected"):
                Suspected Stemp= new Suspected();
                login.person =(Suspected) Stemp;
                login.person=Stemp;
                break;
        }
    }

    public Boolean getVerify()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String Verf= sharedPreferences.getString(Key_Verify,null);

        if (Verf.equals("Yes")) {
            login.person.Verify = true;
            return true;
        }
        else {
            login.person.Verify = false;
            return false;
        }
    }


}
