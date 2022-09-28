package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClientsInfoDB {

    static Connection con = null;

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.101/Client";
            con = DriverManager.getConnection(url,"Mahmoud3","aast123@");
            System.out.println("Connected");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    public static void ReadFromDB()
    {


        List<Person> list = new ArrayList<Person>();

        try {
            String sql = "SELECT * FROM clientInfo WHERE 1";
            Connection con = ClientsInfoDB.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Person person= new Person();



                person.setID(resultSet.getString(1));
                System.out.println(person.getID());
                person.setName(resultSet.getString(2));
                System.out.println(person.getName());
                person.setAge(resultSet.getInt(3));
                System.out.println(person.getAge());
                person.setLocation(resultSet.getString(4));
                System.out.println(person.getLocation());
                person.setPhoneNum(resultSet.getString(5));
                System.out.println(person.getPhoneNum());
                person.setInstitution (resultSet.getString(6));
                System.out.println(person.getInstitution());
                person.setCT(resultSet.getDouble(7));
                System.out.println(person.getCT());

                String VStatus=(resultSet.getString(8));
                Boolean V;

                if(VStatus.equals("Yes"))
                    V=true;
                else
                    V=false;

                person.IsVaccinated=V;
                System.out.println(person.getVaccinated());

                person.setVaccineName(resultSet.getString(9).toString());
                System.out.println(person.getVaccineName());
                person.setFirstDose(resultSet.getString(10));
                System.out.println(person.getFirstDose());

                String Verify=(resultSet.getString(15));

                Boolean Verf;

                if(Verify.equals("Yes"))
                    Verf=true;
                else
                    Verf=false;

                person.setVerify(Verf);
                System.out.println(person.getVerify());

                String type=(resultSet.getString(11));




                switch (type)
                {
                    case ("Positive"):
                        Positive Ptemp= new Positive();
                        person =(Positive) Ptemp;
                        System.out.println(type);
                        Ptemp.setSeverityLevel(resultSet.getInt(12));
                        System.out.println(Ptemp.getSeverityLevel());
                        Ptemp.setContacts(resultSet.getInt(13));
                        System.out.println(Ptemp.getContacts());
                        person=Ptemp;
                        break;

                    case ("Negative"):

                        Negative Ntemp= new Negative();
                        person =(Negative) Ntemp;
                        System.out.println(type);
                        person=Ntemp;
                        break;

                    case ("Quarantined") :
                        Quarantined Qtemp= new Quarantined();
                        person =(Quarantined) Qtemp;
                        System.out.println(type);
                        Qtemp.setArrivedFrom(resultSet.getString(14));
                        System.out.println(Qtemp.getArrivedFrom());
                        person=Qtemp;
                        break;

                    case ("Suspected"):
                        Suspected Stemp= new Suspected();
                        person =(Suspected) Stemp;
                        System.out.println(type);
                        person=Stemp;
                        break;
                }


                list.add(person);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static int Insert(Person x) {
        int st=0;

        try{
            String sql = "INSERT INTO clientInfo " + "VALUES (?,?,?,?,?,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)";
            Connection con = ClientsInfoDB.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, x.getID());
            preparedStatement.setString(2, x.getName());
            preparedStatement.setInt(3, x.getAge());
            preparedStatement.setString(4, x.getLocation());
            preparedStatement.setString(5, x.getPhoneNum());



            st=preparedStatement.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return st;

    }
}
