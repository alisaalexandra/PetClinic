package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import petclinic.Appointment;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    private Connection connection;
    private Stage primarystage;

    @FXML
    private TextField idField;

    @FXML
    private TextField petNameField;

    @FXML
    private TextField petAgeField;

    @FXML
    private TextField ownerLastNameField;

    @FXML
    private TextField ownerFirstNameField;

    @FXML
    private TextField doctorLastNameField;

    @FXML
    private TextField doctorFirstNameField;

    @FXML
    private TextField dateField;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private javafx.scene.control.TableView<Appointment> TableView;

    @FXML
    private TableColumn<Appointment, Integer> idColumn;

    @FXML
    private TableColumn<Appointment, String> petName;

    @FXML
    private TableColumn<Appointment, String> petAge;

    @FXML
    private TableColumn<Appointment, String> ownerLastName;

    @FXML
    private TableColumn<Appointment, String> ownerFirstName;

    @FXML
    private TableColumn<Appointment, String> doctorLastName;

    @FXML
    private TableColumn<Appointment, String> doctorFirstName;

    @FXML
    private TableColumn<Appointment, String> dateColumn;

    public void setPrimarystage(Stage primarystage) {
        this.primarystage = primarystage;
    }

    @FXML
    private void insertButton() {
        String query = "insert into appointment values(" + idField.getText() + ",'"
                + petNameField.getText() + "','" + petAgeField.getText() + "','" +
                ownerLastNameField.getText() + "','" + ownerFirstNameField.getText() + "','"
                + doctorLastNameField.getText() + "','" + doctorFirstNameField.getText() + "','"
                + dateField.getText() + "')";
        executeQuery(query);
        showAppointments();
    }


    @FXML
    private void updateButton() {
        String query = "UPDATE appointment SET Name= '" + petNameField.getText() + "',Age=" + petAgeField.getText() +
                ",Last Name='" + ownerLastNameField.getText() + "',First Name='" + ownerLastNameField.getText() +
                "',Last Name='" + doctorLastNameField.getText() + "',First Name='" + doctorFirstNameField.getText() +
                "',Date='" + dateField.getText() + "' WHERE ID=" + idField.getText() + "";
        executeQuery(query);
        showAppointments();
    }

    @FXML
    private void deleteButton() {
        String query = "DELETE FROM appointment WHERE ID=" + idField.getText() + "";
        executeQuery(query);
        showAppointments();
    }

    public void executeQuery(String query) {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showAppointments();
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url1 = "jdbc:mysql://localhost:3306/petclinic";
            String user = "root";
            String password = "";

            connection = DriverManager.getConnection(url1, user, password);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            e.printStackTrace();
        }
        return connection;
    }

    public ObservableList<Appointment> getApps() {
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        connection = getConnection();
        String query = "SELECT * FROM appointment ";
        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Appointment appointment;
            while (resultSet.next()) {
                appointment = new Appointment(resultSet.getInt("id"), resultSet.getString("petName"),
                        resultSet.getInt("petAge"), resultSet.getString("ownerLastName"),
                        resultSet.getString("ownerFirstName"), resultSet.getString("doctorLastName"),
                        resultSet.getString("doctorFirstName"), resultSet.getString("date"));
                appointments.add(appointment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public void showAppointments() {
        ObservableList<Appointment> list = getApps();

        idColumn.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("id"));
        petName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("petName"));
        ownerLastName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("ownerLastName"));
        ownerFirstName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("ownerFirstName"));
        doctorLastName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctorLastName"));
        doctorFirstName.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctorFirstName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("date"));

        TableView.setItems(list);
    }

    public void exit(ActionEvent actionEvent) {
        primarystage.close();
    }
}
