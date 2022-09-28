package sample;

public class Precautions extends CovidInfo{

    String precautions= "Write Precautions Here";

    public Precautions() {
    }

    @Override
    public String ShowDetails() {
        return super.ShowInfo()+precautions;
    }
}
