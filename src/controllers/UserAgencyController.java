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
import tables.AgencyTableObject;
import tables.ShopTableObject;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserAgencyController extends Controller implements Initializable {


    @FXML
    private TableView<AgencyTableObject> agenciesTable;

    @FXML
    private TableColumn<ShopTableObject, String> colID;

    @FXML
    private TableColumn<ShopTableObject, String> colName;

    @FXML
    private TableColumn<ShopTableObject, String> colDate;

    @FXML
    private TableColumn<ShopTableObject, String> colAddress;

    @FXML
    private JFXButton addAgencyButton;
    @FXML
    private JFXButton refreshAgencyButton;
    @FXML
    private JFXButton deleteAgencyButton;
    @FXML
    private JFXButton BackAgencyButton;

    ObservableList<AgencyTableObject> observableAgencyList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Connection connection = DBConnection.getConnection(null);
            ResultSet rsAgencies = connection.createStatement().executeQuery(Strings.GET_AGENCIES);

            while(rsAgencies.next()) {
                observableAgencyList.add(new AgencyTableObject(
                        rsAgencies.getInt("AgencyID"),
                        rsAgencies.getString("Name"),
                        rsAgencies.getString("agencyDateOfEstablishment"),
                        "Ul." + rsAgencies.getString("STREET") + " " + rsAgencies.getString("HomeNumber") +
                                "/" + rsAgencies.getString("ApartmentNumber") + "  " + rsAgencies.getString("POSTCODE") +
                                " " + rsAgencies.getString("COUNTRY")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong! Cannot get employees data");
        }

        colID.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("AgencyID"));
        colName.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("name"));;
        colDate.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("DateOfEstablishment"));
        colAddress.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("Address"));

        agenciesTable.setItems(observableAgencyList);

    }


    public void refreshAgencyButtononClicked(ActionEvent actionEvent) { setScene(actionEvent,Strings.USER_AGENCY_SAMPLE); }


    public void backAgencyButtononClicked(ActionEvent actionEvent) {
        setScene(actionEvent, Strings.USER_SAMPLE);
    }

}
