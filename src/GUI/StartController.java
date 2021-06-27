package GUI;

import Admin.Affiliation;
import App.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private BorderPane loginPane;

    @FXML
    private ImageView home_view;

    @FXML
    private Button close_button;

    @FXML
    private TextField email_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button login_button;

    @FXML
    private ImageView logo_view;

    @FXML
    private Label login_message;


    @FXML
    private BorderPane registerPane;

    @FXML
    private ImageView background_view;


    @FXML
    private TextField register_email_field;

    @FXML
    private TextField first_field;

    @FXML
    private TextField last_field;

    @FXML
    private TextField phone_field;

    @FXML
    private TextField national_field;

    @FXML
    private PasswordField register_password_field;

    @FXML
    private PasswordField register_repassword_field;

    @FXML
    private Button register_button;

    @FXML
    private Label register_message;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File home = new File("public/Images/homedark.png");
        File logo = new File("public/Images/logo.png");
        File background = new File("public/Images/background.png");
        Image home_png = new Image(home.toURI().toString());
        Image logo_png = new Image(logo.toURI().toString());
        Image background_png = new Image(background.toURI().toString());
        home_view.setImage(home_png);
        logo_view.setImage(logo_png);
        background_view.setImage(background_png);
        home_view.setCache(true);
        logo_view.setCache(true);
        background_view.setCache(true);
    }


    public void loginButtonOnAction(ActionEvent event) throws SQLException {
        if (email_field.getText().isBlank() == true || password_field.getText().isBlank() == true) {
            login_message.setText("Failed to log in. All fields required");
            return;
        }
        String email = email_field.getText().toString();
        String password = password_field.getText().toString();
        User user = new User(email, password);
        if (!(user.Authorized())) {
            login_message.setText("Failed to log in. User not found");
            return;
        }
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }


    public void registerSwitchButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        registerPane.toFront();
    }

    public void loginSwitchButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        loginPane.toFront();
    }

    public void registerButtonOnAction(ActionEvent event) throws SQLException {
        if (register_email_field.getText().isBlank() == true
                || register_password_field.getText().isBlank() == true
                || register_repassword_field.getText().isBlank() == true
                || first_field.getText().isBlank() == true
                || last_field.getText().isBlank() == true
                || phone_field.getText().isBlank() == true
                || national_field.getText().isBlank() == true) {
            register_message.setText("Failed to register. All fields required");
            return;
        }
        String password = register_password_field.getText();
        String rePassword = register_repassword_field.getText();
        if (!(password.equals(rePassword))) {
            register_message.setText("Failed to register. Passwords must match");
            return;
        }
        String first_name = first_field.getText().toString();
        String last_name = last_field.getText().toString();
        String email = email_field.getText().toString();
        String address = email_field.getText().toString();
        int user_id = 100;
        int national_id = Integer.parseInt(national_field.getText().toString());
        int phone_number = Integer.parseInt(phone_field.getText().toString());
        Date creation_date = new Date();
        User user = new User(user_id, national_id, first_name, last_name, password, email, address, creation_date, phone_number);
        //user.AddUser();
        System.out.println(user.AddUser());

        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }


}

