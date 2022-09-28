package sample;

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

    /*public void CreateVacClass(String VName, String FDose)
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

    public void SetLocation() {
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
    }

    public String UIColor()
    {
        return "RED";
    }

    @Override
    public String Instruct() {

        if (IsVaccinated == true)
            return Name + " Is Vaccinated" + inst.ChooseInstruction("PositiveVac");
        else
            return Name + " Is not Vaccinated" + inst.ChooseInstruction("Positive");
    }
}
