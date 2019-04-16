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
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserShopController extends Controller implements Initializable {

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

    public void refreshShopButtononClicked(ActionEvent actionEvent) { setScene(actionEvent, Strings.USER_SHOP_SAMPLE); }

    public void backShopButtononClicked(ActionEvent actionEvent) {setScene(actionEvent, Strings.USER_SAMPLE); }
}
