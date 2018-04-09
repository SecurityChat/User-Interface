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
    private String nickname;

    public static void main(String[] args) throws UnknownHostException, IOException {
        //launch(args);
        new Client("127.0.0.1", 12345).run();

    }

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLSource/interface.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }*/

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws UnknownHostException, IOException {
        // connect client to server
        Socket client = new Socket(host, port);
        System.out.println("Client successfully connected to server!");

        // create a new thread for server messages handling
        new Thread(new ReceivedMessagesHandler(client.getInputStream())).start();

        // ask for a nickname
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a nickname: ");
        nickname = sc.nextLine();

        // read messages from keyboard and send to server
        System.out.println("Send messages: ");
        PrintStream output = new PrintStream(client.getOutputStream());
        while (sc.hasNextLine()) {
            output.println(nickname + ": " + sc.nextLine());
        }

        output.close();
        sc.close();
        client.close();
    }

}

class ReceivedMessagesHandler implements Runnable {

    private InputStream server;

    public ReceivedMessagesHandler(InputStream server) {
        this.server = server;
    }

    @Override
    public void run() {
        // receive server messages and print out to screen
        //этот ран должен выводить сообщение в окно диалога
        Scanner s = new Scanner(server);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
        s.close();
    }
}
