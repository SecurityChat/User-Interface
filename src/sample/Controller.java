package sample;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.BufferOverflowException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        //buttonSend.setOnAction(event -> {
            //System.out.println("Hello");
        //});
        buttonSend.setOnAction(event -> {
            isInputValid();
        });
    }


    private boolean isInputValid() {
        String errorMessage = "";
        String text = inputArea.getText();

        if (text != null) {
            outputArea.setText(text);
        }

        //Иначе, если текста нет - то НИЧЕГО не происходит...
        else if (text == null) errorMessage = "Введите сообщение!";

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }

}

