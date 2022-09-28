package sample;

import java.util.Date;

public class VaccinatedFactory {


        public Person PersonState(String Type,String ID, String name, String location, String phoneNum,  int age, int severityLevel,int contacts)
        {
            if (Type == null)
                return null;
            if (Type.equalsIgnoreCase("Positive"))
                return new Positive(ID, name, location, phoneNum, age,severityLevel,contacts);

            return null;
        }

    public Person PersonState(String Type,String ID, String name, String location, String phoneNum,  int age ) {
        if (Type.equalsIgnoreCase("Suspected"))
            return new Suspected(ID, name, location, phoneNum, age);
        if (Type.equalsIgnoreCase("Negative"))
            return new Negative(ID, name, location, phoneNum, age);

        return null;
    }

    public Person PersonState(String Type,String ID, String name, String location, String phoneNum,  int age, String arrivedFrom){

        if(Type.equalsIgnoreCase("Quarantined"))
            return new Quarantined(ID, name, location, phoneNum, age,arrivedFrom);

        return null;
    }
}

