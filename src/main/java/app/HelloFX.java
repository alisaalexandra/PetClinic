package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Aplicatia JavaFX porneste...");
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader =new  FXMLLoader(getClass().getResource("/Main.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("PET CLINIC");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Aplicatia JavaFX s-a oprit.");
    }

    public static void main(String[] args) {
        launch();
    }
}
