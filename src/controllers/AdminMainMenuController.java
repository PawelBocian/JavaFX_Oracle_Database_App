package controllers;

import attributes.Strings;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainMenuController extends Controller implements Initializable {

    @FXML
    private JFXButton Exit_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Admin screen active");
    }

    public void onShopButtonClicked(ActionEvent actionEvent) { setScene(actionEvent, Strings.SHOP_SAMPLE); }

    public void onAgenciesButtonClicked(ActionEvent actionEvent) { setScene(actionEvent, Strings.AGENCY_SAMPLE); }

    public void onEmployeesButtonClicked(ActionEvent actionEvent) {
        setScene(actionEvent, Strings.EMPLOYEE_SAMPLE);
    }

    public void onExitButtonClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onLogoutButtonClicked(ActionEvent actionEvent) {
        setScene(actionEvent, Strings.LOGIN_SAMPLE);
    }
}
