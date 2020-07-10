package databasecontrol;

import java.sql.*;

public class DatabaseHandler {

    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/petclinic?autoReconnect=true&useSSL=false";
        String user = "root";
        String pass = "qwerty123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.getLocalizedMessage();
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
        }
        return connection;
    }

    public static boolean CheckLoginUser(String id) {
        Connection connection = getConnection();
        String checkQuery = "select * from users where username = ?";

        PreparedStatement preparedStatement = null;
        boolean status = false;
        try {
            preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            status = resultSet.next();
            preparedStatement.close();
            return status;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}

