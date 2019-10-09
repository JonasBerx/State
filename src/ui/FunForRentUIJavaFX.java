package ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class FunForRentUIJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Label label = new Label("Test");
        ComboBox<String> encoderComboBox = new ComboBox<>(FXCollections.observableList(Arrays.asList(
                "Ceasar",
                "Mirror"
        )));
        root.getChildren().addAll(label, encoderComboBox);
        Scene mainScene = new Scene(root, 250, 40);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
