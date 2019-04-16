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
import tables.ShopTableObject;
import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminShopController extends Controller implements Initializable {

    @FXML
    private TableView<ShopTableObject> shopsTable;

    @FXML
    private TableColumn<ShopTableObject, String> colID;

    @FXML
    private TableColumn<ShopTableObject, String> colName;

    @FXML
    private TableColumn<ShopTableObject, String> colDate;

    @FXML
    private TableColumn<ShopTableObject, String> colSurface;

    @FXML
    private TableColumn<ShopTableObject, String> colNumberOfAgencies;

    @FXML
    private JFXButton addEmployeeButton;

    @FXML
    private JFXButton refreshEmployeeButton;

    @FXML
    private JFXButton deleteEmployeeButton;

    @FXML
    private JFXButton BackEmployeeButton;

    ObservableList<ShopTableObject> observableShopsList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Connection connection = DBConnection.getConnection(null);
            ResultSet rsShops = connection.createStatement().executeQuery(Strings.GET_SHOPS);

            while(rsShops.next()) {

                ResultSet rsNumber = connection.createStatement().executeQuery(Strings.GET_NUMBER_OF_AGENCIES + rsShops.getString("SHOPID"));

                while(rsNumber.next()) {
                    observableShopsList.add(new ShopTableObject(
                            Integer.parseInt(rsShops.getString("SHOPID")),
                            rsShops.getString("NAME"),
                            rsNumber.getInt("Liczba"),
                            rsShops.getString("DATEOFESTABLISHMENT"),
                            rsShops.getString("SURFACE")

                    ));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong! Cannot get employees data");
        }

        colID.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("ShopID"));
        colName.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("name"));;
        colDate.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("DateOfEstablishment"));
        colSurface.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("Surface"));
        colNumberOfAgencies.setCellValueFactory(new PropertyValueFactory<ShopTableObject,String>("numberOfAgencies"));

        shopsTable.setItems(observableShopsList);

    }

    public void addShopButtononClicked(ActionEvent actionEvent) {
        //TODO MIRROR CODE AS ADD_EMPLOYEE
    }

    public void refreshShopButtononClicked(ActionEvent actionEvent) { setScene(actionEvent, Strings.SHOP_SAMPLE); }

    public void deleteShopButtononClicked(ActionEvent actionEvent) {
        String query = Strings.REMOVE_SHOP_BY_ID + shopsTable.getSelectionModel().getSelectedItem().getShopID();

        try{
            Connection connection = DBConnection.getConnection(null);
            ResultSet rsAgencies = connection.createStatement().executeQuery(query);
            ShopTableObject selectedItem = shopsTable.getSelectionModel().getSelectedItem();
            shopsTable.getItems().remove(selectedItem);

        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Something went wrong! Cannot remove shop", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void backShopButtononClicked(ActionEvent actionEvent) {setScene(actionEvent, Strings.ADMIN_SAMPLE); }
}
