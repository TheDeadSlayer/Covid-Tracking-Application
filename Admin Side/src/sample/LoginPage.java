package sample;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage {
    public void OpenDB(MouseEvent mouseEvent) {

        Button btn = (Button) mouseEvent.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();

        try {
            Main.openDB();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
