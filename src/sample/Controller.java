package sample;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;



public class Controller {


    private Stage dialogStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSend;

    @FXML
    private TextArea inputArea;

    @FXML
    private TextArea outputArea;


    @FXML
    void initialize() {
        //assert inputArea != null : "fx:id=\"inputArea\" was not injected: check your FXML file 'interface.fxml'.";
        //assert outputArea != null : "fx:id=\"outputArea\" was not injected: check your FXML file 'interface.fxml'.";


        // Реализация кнопки через лямбда-выражение:
        /*buttonSend.setOnAction(event -> {
            printMsg();
        });*/


        buttonSend.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                printMsg();
            }
        });
    }

    private String getMsg() {
        String msg = inputArea.getText();
        return msg;
    }

    private void printMsg() {
        String msg = getMsg();
        inputArea.clear();
        outputArea.appendText(msg + "\n");
        outputArea.positionCaret(0);
    }


}