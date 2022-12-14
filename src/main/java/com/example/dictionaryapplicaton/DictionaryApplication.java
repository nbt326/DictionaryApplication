package com.example.dictionaryapplicaton;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static com.example.dictionaryapplicaton.DictionaryController.dictionaryManagement;


public class DictionaryApplication extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        Scene scene = new Scene(root, 600,600);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                dictionaryManagement.exportHistoryWord();
                dictionaryManagement.exportFavouriteWord();
            }
        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}