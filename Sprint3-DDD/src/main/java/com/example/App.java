package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregue o arquivo FXML com o caminho correto
        Parent root = FXMLLoader.load(getClass().getResource("/entrar.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Sua Aplicação JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
