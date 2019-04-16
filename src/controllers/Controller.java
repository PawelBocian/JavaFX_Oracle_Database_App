package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

abstract class Controller {
    /**
     * Changing Scenes
     */
    void setScene(ActionEvent actionEvent, String samplePath) {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            root = loader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(samplePath)));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while changing scene: " + samplePath);
        }
        assert root != null;
        stage.setScene(new Scene(root,800,500));
    }

}