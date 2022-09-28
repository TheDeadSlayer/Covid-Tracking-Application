package sample;

/*public class PCRTest extends Person{

    String Institution;
    Double CT;
    String Result;
    boolean FitForTravel=false;

    public PCRTest(String ID, String name, String location, String phoneNum, int age, String institution, Double CT) {
        super(ID, name, location, phoneNum, age);
        Institution = institution;
        this.CT = CT;
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

    public Double getCT() {
        return CT;
    }

    public void setCT(Double CT) {

        if(CT>=0&&CT<=100)
         this.CT = CT;
    }

    public void Res(Vaccinated x,Boolean Vac)
    {
        if (CT==0) {
            Result = "Negative";
            x= new Negative(ID, Name, Location, PhoneNum, Vac,Age);
        }
        else if(CT>0&&CT<=30) {
            Result = "Positive";
            x = new Positive(ID, Name, Location, PhoneNum, Vac,Age);
        }

        else {
            Result="Reactive";
            x=new Suspected(ID, Name, Location, PhoneNum, Vac,Age);
        }

    }

    public void Travel()
    {
        if(Result=="Negative")
            FitForTravel=true;
        else
            FitForTravel=false;
    }


}*/
