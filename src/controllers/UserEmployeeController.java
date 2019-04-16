package controllers;

import attributes.Strings;
import com.jfoenix.controls.JFXButton;
import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tables.EmployeeTableObject;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserEmployeeController extends Controller implements Initializable {


    @FXML
    private TableView<EmployeeTableObject> employeesTable;

    @FXML
    private TableColumn<EmployeeTableObject, String> colID;

    @FXML
    private TableColumn<EmployeeTableObject, String> colName;

    @FXML
    private TableColumn<EmployeeTableObject, String> colSurname;

    @FXML
    private TableColumn<EmployeeTableObject, String> colDate;

    @FXML
    private TableColumn<EmployeeTableObject, String> colGender;

    @FXML
    private TableColumn<EmployeeTableObject, String> colPesel;

    @FXML
    private TableColumn<EmployeeTableObject, String> colAddress;

    @FXML
    private TableColumn<EmployeeTableObject, String> colJobTitle;

    @FXML
    private JFXButton addEmployeeButton;

    @FXML
    private JFXButton refreshEmployeeButton;

    @FXML
    private JFXButton deleteEmployeeButton;



    ObservableList<EmployeeTableObject> observableEmployeesList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Connection connection = DBConnection.getConnection(null);
            ResultSet rsEmployees = connection.createStatement().executeQuery(Strings.GET_EMPLOYEE);

            while(rsEmployees.next()) {
                observableEmployeesList.add(new EmployeeTableObject(
                        Integer.parseInt(rsEmployees.getString("EmployeeID")),
                        rsEmployees.getString("NAME"),
                        rsEmployees.getString("SURNAME"),
                        rsEmployees.getString("DATEOFEMPLOYMENT"),
                        rsEmployees.getString("GENDER"),
                        rsEmployees.getString("PESEL"),
                        "Ul." + rsEmployees.getString("STREET") + " " + rsEmployees.getString("HomeNumber") +
                                "/" + rsEmployees.getString("ApartmentNumber") + "  " + rsEmployees.getString("POSTCODE") +
                                " " + rsEmployees.getString("COUNTRY"),
                        rsEmployees.getString("JOBNAME")
                ));
            }
            }catch(SQLException e){
                e.printStackTrace();
                System.out.println("Something went wrong! Cannot get employees data");
            }

        colID.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("EmployeeID"));
        colName.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("name"));
        colSurname.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("surname"));
        colDate.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("dateOfEmployment"));
        colGender.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("gender"));
        colPesel.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("pesel"));
        colAddress.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("Address"));
        colJobTitle.setCellValueFactory(new PropertyValueFactory<EmployeeTableObject,String>("jobTitle"));

        employeesTable.setItems(observableEmployeesList);

    }

    public void refreshEmployeeButtononClicked(ActionEvent actionEvent) { setScene(actionEvent,Strings.USER_EMPLOYEE_SAMPLE); }

    public void backEmployeeButtononClicked(ActionEvent actionEvent) {
            setScene(actionEvent, Strings.USER_SAMPLE);
    }
}
