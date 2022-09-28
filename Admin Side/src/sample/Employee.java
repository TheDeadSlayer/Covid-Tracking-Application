package sample;

public class Employee {

    String Name;
    String MedID;
    String Title;

    public Employee() {
    }

    public Employee(String name, String medID, String title) {
        Name = name;
        MedID = medID;
        Title = title;
    }

    public String getMedID() {
        return MedID;
    }

    public void setMedID(String medID) {
        if(medID.length()==8)
            MedID = medID;
    }


}
