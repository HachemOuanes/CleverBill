package GUI;

import App.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button close_button;
    @FXML
    private Label login_message;
    @FXML
    private ImageView home_view;
    @FXML
    private ImageView logo_view;
    @FXML
    private TextField email_field;
    @FXML
    private TextField password_field;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File home = new File("public/Images/home.png");
        File logo = new File("public/Images/logo.png");
        Image home_png = new Image(home.toURI().toString());
        Image logo_png = new Image(logo.toURI().toString());
        home_view.setImage(home_png);
        logo_view.setImage(logo_png);
        home_view.setCache(true);
        logo_view.setCache(true);
    }


    public void loginButtonOnAction(ActionEvent event) throws SQLException {
        if (email_field.getText().isBlank() == true || password_field.getText().isBlank() == true) {
            login_message.setText("Failed to log in. All fields required");
            return;
        }
        String email = email_field.getText().toString();
        String password = password_field.getText().toString();
        User user = new User();
        if (!(user.Authorized(email,password))){
            login_message.setText("Failed to log in. User not found");
            return;
        }
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }



    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }


}

