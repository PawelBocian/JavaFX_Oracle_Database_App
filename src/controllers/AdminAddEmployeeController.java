package controllers;

import attributes.Strings;
import com.jfoenix.controls.JFXTextField;
import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminAddEmployeeController extends Controller implements Initializable {


    @FXML
    private JFXTextField name_text;

    @FXML
    private JFXTextField surname_text;

    @FXML
    private JFXTextField date_text;

    @FXML
    private JFXTextField gender_text;

    @FXML
    private JFXTextField pesel_text;

    @FXML
    private JFXTextField agency_text;

    @FXML
    private JFXTextField jobtitle_text;

    @FXML
    private JFXTextField address_text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name_text.setStyle("-fx-prompt-text-fill: white");
        surname_text.setStyle("-fx-prompt-text-fill: white");;
        date_text.setStyle("-fx-prompt-text-fill: white");
        gender_text.setStyle("-fx-prompt-text-fill: white");
        pesel_text.setStyle("-fx-prompt-text-fill: white");
        agency_text.setStyle("-fx-prompt-text-fill: white");
        jobtitle_text.setStyle("-fx-prompt-text-fill: white");
        address_text.setStyle("-fx-prompt-text-fill: white");
    }

    public void onAddEmployeeButtonClicked(ActionEvent actionEvent) {

        if(date_text.getLength() != 10)
            JOptionPane.showMessageDialog(null,"Expected date format YYYY-MM-DD","Incorrect Date Format",JOptionPane.WARNING_MESSAGE);
        if(gender_text.getLength() != 1)
            JOptionPane.showMessageDialog(null,"Expected gender format 'K' or 'M'","Incorrect Date Format",JOptionPane.WARNING_MESSAGE);
        if(pesel_text.getLength() != 11 )
            JOptionPane.showMessageDialog(null,"Expected pesel length 11 characters","Incorrect Date Format",JOptionPane.WARNING_MESSAGE);

        String query = "insert into employees (name,surname,dateOfEmployment,gender,pesel,agencyid,JobTitleId,AddressID)\n" +
                "Values('"+ name_text.getText() +"','" + surname_text.getText() +"','" + date_text.getText() +"','" + gender_text.getText() +
                "','" + pesel_text.getText() + "'," + Integer.parseInt(agency_text.getText())+ "," + Integer.parseInt(jobtitle_text.getText())+
                ","+Integer.parseInt(address_text.getText()) +")";
        try{

            Connection connection = DBConnection.getConnection(null);
            ResultSet addEmployee = connection.createStatement().executeQuery(query);
            setScene(actionEvent, Strings.EMPLOYEE_SAMPLE);

        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Something went wrong! Cannot add employees",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void onBackEmployeeButtonClicked(ActionEvent actionEvent) { setScene(actionEvent, Strings.EMPLOYEE_SAMPLE); }
}
