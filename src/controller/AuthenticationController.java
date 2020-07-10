package controller;

import databasecontrol.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import petclinic.Appointment;
import petclinic.User;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class AuthenticationController implements Initializable {
    private Stage currentStage;
    private Stage primaryStage;
    private Connection connection;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private TextField txtUsername;

    @FXML
    private Label txtStatus;


    @FXML
    private TextField registerUsername;

    @FXML
    private TextField registerUsernameConfirm;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    @FXML
    public void loginButton(ActionEvent actionEvent) throws IOException {
        if (DatabaseHandler.CheckLoginUser(txtUsername.getText())) {
            loginButton.getScene().getWindow().hide();
            Stage dashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/Application.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.setTitle("APPOINTMENTS");
            dashboardStage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Error in login system");
            alert.show();
            txtUsername.setText("");
        }
    }

    public void showUsers() {
        ObservableList<User> list = getUsers();
    }

    public void executeQuery(String query) {
        connection = DatabaseHandler.getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToMainWindow(ActionEvent actionEvent) throws IOException {
        if (currentStage.isShowing()) {
            currentStage.hide();
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/view/MainWindow.fxml"));
        Parent parent = (Parent) loader.load();
        Stage mainStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        mainStage.setScene(scene);
        mainStage.setTitle("PET CLINIC");
        mainStage.show();
    }

    public ObservableList<User> getUsers() {
        ObservableList<User> users = FXCollections.observableArrayList();
        connection = DatabaseHandler.getConnection();
        String query = "SELECT * FROM users ";
        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            User user;
            while (resultSet.next()) {
                user = new User(resultSet.getString("username"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @FXML
    public void registerButton() {
        if (!DatabaseHandler.CheckLoginUser(registerUsername.getText())) {
            if(registerUsername.getText().equals(registerUsernameConfirm.getText())) {
                    User newUser = new User(registerUsername.getText());
                    getUsers().add(newUser);
                    String query = "insert into users values ( " + registerUsername.getText() + ")";
                    executeQuery(query);
                    showUsers();
                    txtStatus.setText("Registration successfully!");
                }
        } else  if (DatabaseHandler.CheckLoginUser(registerUsername.getText())) {
            txtStatus.setText("User already registered!");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showUsers();
    }
}
