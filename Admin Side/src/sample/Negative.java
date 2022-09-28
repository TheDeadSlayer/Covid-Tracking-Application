package sample;

public class Negative extends Person{
    Instructions x = new Instructions();

    public Negative() {
    }

    public Negative(String ID, String name, String location, String phoneNum, int age) {
        super(ID, name, location, phoneNum, age);
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
