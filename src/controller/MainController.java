package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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

    public void exit(ActionEvent actionEvent) {
        primaryStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){;
    }
    public void login(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/view/Login.fxml"));
        Parent parent = (Parent) loader.load();
        loginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ((AuthenticationController) loader.getController()).setCurrentStage(loginStage);
        Scene scene = new Scene(parent);
        loginStage.setScene(scene);
        loginStage.setTitle("LOGIN");
        loginStage.show();

    }

    public void register(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/view/Register.fxml"));
        Parent parent = (Parent) loader.load();
        loginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ((AuthenticationController) loader.getController()).setCurrentStage(loginStage);
        Scene scene = new Scene(parent);
        loginStage.setScene(scene);
        loginStage.setTitle("REGISTER");
        loginStage.show();
    }
}
