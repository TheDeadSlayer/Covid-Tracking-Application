package sample;

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


    /*  public void CreateVacClass(String VName,String FDose)
    {
        if(IsVaccinated) {
            Vaccines vac = new Vaccines(this.ID, this.Name, this.Location, this.PhoneNum, this.Age, VName);
            vac.FirstDose=FDose;
        }

    }

    public void CreatePCRClass(String Institution, Double CT)
    {
        PCRTest pcr= new PCRTest(this.ID,this.Name,this.Location,this.PhoneNum,this.Age,Institution,CT);
    }*/

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
