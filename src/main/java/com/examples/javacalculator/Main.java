package com.examples.javacalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main extends Application {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage stage) throws IOException {
        Calculator calculator = new Calculator();

        Scene scene = new Scene(calculator.createScene(), 300, 400);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        log.info("Application is starting");
        launch();
    }
}