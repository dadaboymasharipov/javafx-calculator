package com.examples.javacalculator;

import com.examples.javacalculator.service.CalculatorService;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static com.examples.javacalculator.constants.StaticConstants.*;

public class Calculator {

    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    private final TextField display = new TextField();
    private String operator = "";
    private double num1 = 0.0;

    public Parent createScene() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(GAP));
        vBox.setSpacing(GAP);

        display.setFont(Font.font(24));
        display.setEditable(false);
        display.setPrefHeight(50);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(GAP);
        gridPane.setHgap(GAP);

        String[] buttonLabels = {
                "9", "8", "7", "/",
                "6", "5", "4", "*",
                "3", "2", "1", "+",
                "C", "0", "=", "-",
                "←", "."
        };

        int col = 0;
        int row = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
            button.setFont(Font.font(18));


            button.setOnAction(e -> onButtonClicked(label));

            gridPane.add(button, col, row);

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        vBox.getChildren().addAll(display, gridPane);
        return vBox;
    }

    private void onButtonClicked(String label) {
        if (Objects.equals(display.getText(), DIV_BY_ZERO_ERROR) || Objects.equals(display.getText(), INVALID_INPUT)) {
            display.clear();
        }

        switch (label) {
            case "←" -> {
                if (!display.getText().isEmpty()) {
                    String text = display.getText();
                    text = text.substring(0, text.length() - 1);
                    display.setText(text);
                }
            }
            case "." -> {
                if (display.getText().isEmpty()) {
                    display.setText("0.");
                } else if (!display.getText().contains(".")) {
                    display.appendText(".");

                }
            }
            case "C" -> {
                display.clear();
                num1 = 0.0;
                operator = "";
                log.info("Button '{}' is clicked", label);
            }
            case "=" -> calculate();
            case "+", "-", "/", "*" -> {
                if (!display.getText().isEmpty()) {
                    operator = label;
                    try {
                        num1 = Double.parseDouble(display.getText());
                    } catch (NumberFormatException e) {
                        log.info("Invalid number format in display {}", display.getText());
                        display.setText(INVALID_INPUT);
                    }
                    display.clear();
                    log.info("Button '{}' is clicked", label);
                }
            }
            default -> display.appendText(label);
        }


    }

    private void calculate() {
        log.info("Button '=' is clicked");
        if (display.getText().isEmpty() || operator.isEmpty()) {
            log.info("Second param is not entered before calling '=' function");
            return;
        }


        double num2;
        try {
            num2 = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            log.info("Invalid number format in display: {}", display.getText());
            display.setText(INVALID_INPUT);
            return;
        }
        double result = 0.0;

        switch (operator) {
            case "+" -> {
                result = CalculatorService.add(num1, num2);
                log.info("{} {} {} = {}", num1, operator, num2, result);
            }
            case "-" -> {
                result = CalculatorService.subtract(num1, num2);
                log.info("{} {} {} = {}", num1, operator, num2, result);
            }
            case "*" -> {
                result = CalculatorService.multiply(num1, num2);
                log.info("{} {} {} = {}", num1, operator, num2, result);
            }
            case "/" -> {
                if (num2 == 0) {
                    display.setText(DIV_BY_ZERO_ERROR);
                    log.info("Divide by zero error! {} / 0", num1);
                    return;
                }
                result = CalculatorService.divide(num1, num2);
                log.info("{} {} {} = {}", num1, operator, num2, result);
            }
        }
        display.setText(result + "");
        log.info("result is displayed");
        operator = "";
    }
}






