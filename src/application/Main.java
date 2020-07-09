package application;

import controller.ApplicationController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void stop() throws Exception {
        System.out.println("Application stopped...");
        super.stop();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Application started...");
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/view/MainWindow.fxml"));
        Parent parent = (Parent) loader.load();
        ((MainController) loader.getController()).setPrimaryStage(stage);
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("PET CLINIC");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
