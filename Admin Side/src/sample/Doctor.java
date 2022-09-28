package sample;

public class Doctor extends Employee{

    String Medicine;
    int RestDays;

    public Doctor(String name, String medID, String title) {
        super(name, medID, title);
    }

    public Doctor(String name, String medID, String title, String medicine, int restDays) {
        super(name, medID, title);
        Medicine = medicine;
        RestDays = restDays;
    }

    public String ShowPrescription()
    {
        return "Medicine:\n"+Medicine+"\nRecommended Vacation:"+RestDays;
    }
}
