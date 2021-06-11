package GUI;

import Database.Connector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.ResultSet;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 900, 600));
        root.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        Connector connect = new Connector();
//        ResultSet result = connect.read("select * from user");
//        System.o
    }
}
