package app;

import business.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.UserModel;

import java.io.IOException;

public class Controller {

    private UserService userService = new UserService();

    @FXML
    private Label txtStatus;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField registerUsername;

    @FXML
    private TextField registerPassword;

    @FXML
    private TextField registerConfirmation;

    private Stage primaryStage;
    private Stage loginStage = new Stage();
    private Stage registerStage = new Stage();
    private Stage menuStage = new Stage();
    private Stage doctorStage = new Stage();
    private Stage appointmentStage = new Stage();
    private Stage currentStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
//TODO---------------------------------------------------- MAIN WINDOW -----------------------------------------------

    public void loginWindow(ActionEvent actionEvent) throws IOException {
        if (primaryStage.isShowing()) {
            primaryStage.hide();
        }
        Parent loginView = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        Scene loginScene = new Scene(loginView);
        loginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.setTitle("LOGIN");
        loginStage.show();

    }

    public void registerWindow(ActionEvent actionEvent) throws IOException {
        if (primaryStage.isShowing()) {
            primaryStage.hide();
        }
        Parent registerView = FXMLLoader.load(getClass().getResource("/Register.fxml"));
        Scene registerScene = new Scene(registerView);
        registerStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        registerStage.setScene(registerScene);
        registerStage.setTitle("REGISTER");
        registerStage.show();

    }

    public void exit(ActionEvent actionEvent) {
        primaryStage.close();
    }
    //TODO---------------------------------------------------- LOGIN & REGISTER USER -----------------------------------------------

    public void loginUser(ActionEvent actionEvent) throws IOException {
        if (loginStage.isShowing()) {
            loginStage.hide();
        }
        UserModel user = new UserModel();
        user.setUsername(txtUsername.toString());
        user.setPassword(txtPassword.toString());
        boolean isRegistered = userService.login(user);
        if (isRegistered) {
            try {
                Parent menuView = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
                Scene menuScene = new Scene(menuView);
                menuStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                menuStage.setScene(menuScene);
                menuStage.setTitle("MENU");
                menuStage.show();
                currentStage = menuStage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            txtStatus.setText("Username or password incorrect!");
        }
    }

    public void registerUser(ActionEvent actionEvent) {
        if (loginStage.isShowing()) {
            loginStage.hide();
        }
        if (registerUsername.getText().equals("user") && registerPassword.getText().equals("pass") &&
                registerConfirmation.getText().equals("pass")) {
            try {
                Parent loginView = FXMLLoader.load(getClass().getResource("/Login.fxml"));
                Scene loginScene = new Scene(loginView);
                loginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                loginStage.setScene(loginScene);
                loginStage.setTitle("LOGIN");
                loginStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Parent loginView = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        Scene loginScene = new Scene(loginView);
        loginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.setTitle("LOGIN");
        loginStage.show();
    }

    //TODO---------------------------------------------------- MENU -----------------------------------------------

    public void doctorUI(ActionEvent actionEvent) throws IOException {
        if (menuStage.isShowing()) {
            menuStage.close();
        }
        Parent doctorView = FXMLLoader.load(getClass().getResource("/Doctors.fxml"));
        Scene doctorScene = new Scene(doctorView);
        doctorStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        doctorStage.setScene(doctorScene);
        doctorStage.setTitle("DOCTORS");
        doctorStage.show();
    }


    public void appointmentUI(ActionEvent actionEvent) throws IOException {
        if (menuStage.isShowing()) {
            menuStage.close();
        }
        Parent appointmentView = FXMLLoader.load(getClass().getResource("/Appointments.fxml"));
        Scene appointmentScene = new Scene(appointmentView);
        appointmentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appointmentStage.setScene(appointmentScene);
        appointmentStage.setTitle("APPOINTMENTS");
        appointmentStage.show();
    }

    //TODO---------------------------------------------------- DOCTOR MENU -----------------------------------------------


    public void addDoctor(ActionEvent actionEvent) {
    }

    public void viewDoctors(ActionEvent actionEvent) {
    }

    public void updateDoctors(ActionEvent actionEvent) {
    }

    public void deleteDoctor(ActionEvent actionEvent) {
    }

    //TODO---------------------------------------------------- APPOINTMENT MENU -----------------------------------------------

    public void addAppointment(ActionEvent actionEvent) {
    }

    public void viewAppointments(ActionEvent actionEvent) {
    }

    public void updateAppointment(ActionEvent actionEvent) {
    }

    public void deleteAppointment(ActionEvent actionEvent) {
    }

    public void backToMenu(ActionEvent actionEvent) throws IOException {
        if (appointmentStage.isShowing()) {
            appointmentStage.hide();
        } else if (doctorStage.isShowing()) {
            doctorStage.hide();
        }
        Parent menuView = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
        Scene menuScene = new Scene(menuView);
        menuStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        menuStage.setScene(menuScene);
        menuStage.setTitle("MENU");
        menuStage.show();
        currentStage = menuStage;
    }
}
