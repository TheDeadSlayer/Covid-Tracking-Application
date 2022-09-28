package sample;

import java.util.Date;

public class ClientInfoTable {

    String ID;
    String Name;
    int Age;
    String Location;
    String PhoneNum;
    String Institution;
    double CT;
    Boolean VacStatus;
    String VaccineName;
    Date FirstDose= new Date();
    String Type;
    int SeverityLevel;
    int Contacts;
    String ArrivedFrom;
    Boolean Verified;

    public ClientInfoTable(String ID, String name, int age, String location, String phoneNum, String institution, double CT, Boolean vacStatus, String type, Boolean verified) {
        this.ID = ID;
        Name = name;
        Age = age;
        Location = location;
        PhoneNum = phoneNum;
        Institution = institution;
        this.CT = CT;
        VacStatus = vacStatus;
        Type = type;
        Verified = verified;
    }

    public ClientInfoTable(String ID, String name, int age, String location, String phoneNum, String institution, double CT, Boolean vacStatus, String vaccineName, Date firstDose, String type, Boolean verified) {
        this.ID = ID;
        Name = name;
        Age = age;
        Location = location;
        PhoneNum = phoneNum;
        Institution = institution;
        this.CT = CT;
        VacStatus = vacStatus;
        VaccineName = vaccineName;
        FirstDose = firstDose;
        Type = type;
        Verified = verified;
    }

    public ClientInfoTable(String ID, String name, int age, String location, String phoneNum, String institution, double CT, Boolean vacStatus, String vaccineName, Date firstDose, String type, int severityLevel, int contacts, Boolean verified) {
        this.ID = ID;
        Name = name;
        Age = age;
        Location = location;
        PhoneNum = phoneNum;
        Institution = institution;
        this.CT = CT;
        VacStatus = vacStatus;
        VaccineName = vaccineName;
        FirstDose = firstDose;
        Type = type;
        SeverityLevel = severityLevel;
        Contacts = contacts;
        Verified = verified;
    }

    public ClientInfoTable(String ID, String name, int age, String location, String phoneNum, String institution, double CT, Boolean vacStatus, String vaccineName, Date firstDose, String type, String arrivedFrom, Boolean verified) {
        this.ID = ID;
        Name = name;
        Age = age;
        Location = location;
        PhoneNum = phoneNum;
        Institution = institution;
        this.CT = CT;
        VacStatus = vacStatus;
        VaccineName = vaccineName;
        FirstDose = firstDose;
        Type = type;
        ArrivedFrom = arrivedFrom;
        Verified = verified;
    }

    public ClientInfoTable(String ID, String name, int age, String location, String phoneNum, String institution, double CT, Boolean vacStatus, String type, int severityLevel, int contacts, Boolean verified) {
        this.ID = ID;
        Name = name;
        Age = age;
        Location = location;
        PhoneNum = phoneNum;
        Institution = institution;
        this.CT = CT;
        VacStatus = vacStatus;
        Type = type;
        SeverityLevel = severityLevel;
        Contacts = contacts;
        Verified = verified;
    }

    public ClientInfoTable(String ID, String name, int age, String location, String phoneNum, String institution, double CT, Boolean vacStatus, String type, String arrivedFrom, Boolean verified) {
        this.ID = ID;
        Name = name;
        Age = age;
        Location = location;
        PhoneNum = phoneNum;
        Institution = institution;
        this.CT = CT;
        VacStatus = vacStatus;
        Type = type;
        ArrivedFrom = arrivedFrom;
        Verified = verified;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if(ID.length()<=14)
         this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
       if(age>0)
        Age = age;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if(phoneNum.length()<=11)
        PhoneNum = phoneNum;
    }

    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    public double getCT() {
        return CT;
    }

    public void setCT(double CT) {
        if(CT>=0&&CT<=100)
            this.CT = CT;
    }

    public Boolean getVacStatus() {
        return VacStatus;
    }

    public void setVacStatus(Boolean vacStatus) {
        VacStatus = vacStatus;
    }

    public String getVaccineName() {
        return VaccineName;
    }

    public void setVaccineName(String vaccineName) {
        VaccineName = vaccineName;
    }

    public Date getFirstDose() {
        return FirstDose;
    }

    public void setFirstDose(Date firstDose) {
        FirstDose = firstDose;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        if(type=="Positive"||type=="Negative"||type=="Quarantined"||type=="Suspected")
        Type = type;
    }

    public int getSeverityLevel() {
        return SeverityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        if(severityLevel<=3&&severityLevel>0)
        SeverityLevel = severityLevel;
    }

    public int getContacts() {
        return Contacts;
    }

    public void setContacts(int contacts) {
        Contacts = contacts;
    }

    public String getArrivedFrom() {
        return ArrivedFrom;
    }

    public void setArrivedFrom(String arrivedFrom) {
        ArrivedFrom = arrivedFrom;
    }

    public Boolean getVerified() {
        return Verified;
    }

    public void setVerified(Boolean verified) {
        Verified = verified;
    }
}
