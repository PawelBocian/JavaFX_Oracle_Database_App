package main;

import attributes.Strings;
import attributes.Values;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(Strings.LOGIN_SAMPLE)));

        Image img = new Image(Strings.ICON_PATH);
        primaryStage.getIcons().add(img);

        primaryStage.setTitle(Strings.APP_NAME);
        primaryStage.setScene(new Scene(root, Values.APP_WIDTH, Values.APP_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
