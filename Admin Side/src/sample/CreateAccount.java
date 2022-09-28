package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateAccount {
    public TextField txt_ID;
    public TextField txt_Name;
    public TextField txt_Age;
    public TextField txt_Loc;
    public TextField txt_PhoneNum;
    public Button Btn_Create;

    public void CreateAcc(MouseEvent mouseEvent) {






        try {

            Person x = new Person(txt_ID.getText(), txt_Name.getText(), txt_Loc.getText(), txt_PhoneNum.getText(), Integer.parseInt(txt_Age.getText()));
            ClientsInfoDB.Insert(x);
        }
        catch (Exception e)
        {
            System.out.printf("ouch");
        }

    }
}
