package controllers;

import attributes.Strings;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {

    @FXML
    private JFXTextField login_text;

    @FXML
    private JFXPasswordField password_text;

    @FXML
    private JFXButton login_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login_text.setStyle("-fx-prompt-text-fill: white");
        password_text.setStyle("-fx-prompt-text-fill: white");
    }

    public void onLoginButtonClicked(javafx.event.ActionEvent actionEvent) {

        if(Strings.ADMIN_LOGIN.equals(login_text.getText()) && Strings.ADMIN_PASSWORD.equals(password_text.getText()))
            setScene(actionEvent, Strings.ADMIN_SAMPLE);
        else if(Strings.USER_LOGIN.equals(login_text.getText()) && Strings.USER_PASSWORD.equals(password_text.getText()))
            setScene(actionEvent, Strings.USER_SAMPLE);
        else
            JOptionPane.showMessageDialog(null," Incorrect login/password data!","Failure",JOptionPane.ERROR_MESSAGE);
    }
}
