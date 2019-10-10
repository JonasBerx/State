package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public abstract class jfxHelpers {
    public static Button button(String text, EventHandler<ActionEvent> handler) {
        var button = new Button(text);
        button.setPadding(new Insets(5, 5, 5, 5));
        button.setOnAction(handler);
        return button;
    }

    public static Label title(String title) {
        Label label = new Label(title);
        label.setStyle("-fx-font-size: 24;");
        return label;
    }

    public static VBox root(Runnable escHandler) {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(5);
        vBox.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                escHandler.run();
            }
        });
        return vBox;
    }

    public static void showRegion(Stage stage, Region parent) {
        var scene = new Scene(parent, parent.getPrefHeight(), parent.getPrefWidth());
        stage.setScene(scene);
        stage.show();
    }

    public static void exceptionHandler(Exception ex) {
        ex.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Unknown exception");
        alert.setHeaderText("An unknown exception occurred");
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }
}
