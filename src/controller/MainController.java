package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private Stage primaryStage;
    private Stage loginStage;

    public Stage getLoginStage() {
        return loginStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void app(ActionEvent actionEvent) throws IOException {
        if (primaryStage.isShowing()) {
            primaryStage.hide();
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/view/Application.fxml"));
        Parent parent = (Parent) loader.load();
        loginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ((ApplicationController) loader.getController()).setPrimarystage(loginStage);
        Scene scene = new Scene(parent);
        loginStage.setScene(scene);
        loginStage.setTitle("APPOINTMENT");
        loginStage.show();
    }

    public void exit(ActionEvent actionEvent) {
        primaryStage.close();
    }
}
