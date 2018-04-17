package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client /*extends Application*/ {

    private String host;
    private int port;

    public static void main(String[] args) throws UnknownHostException, IOException {
        //launch(args);
        new Client("127.0.0.1", 12345).run();
    }

    //@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLSource/interface.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
        //new Client("192.168.0.1", 12345).run();
    }

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws UnknownHostException, IOException {
        // connect client to server
        Socket client = new Socket(host, port);
        System.out.println("Client successfully connected to server!");
        client.close();
    }
}