package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public WebView Web_Database;

    public WebEngine engine;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        engine= Web_Database.getEngine();
        engine.load("http://localhost/phpmyadmin/index.php?route=/sql&db=cleint&table=client+info&pos=0");

    }
}
