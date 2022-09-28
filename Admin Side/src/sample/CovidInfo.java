package sample;

public abstract class CovidInfo {

    String Information="Write Info Here";

    public CovidInfo() {
    }


    public String ShowInfo()
    {
        return Information;
    }

    public abstract String ShowDetails();
}
