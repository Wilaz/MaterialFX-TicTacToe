package tictactoe;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class app extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a MaterialFX Button
        MFXButton materialButton = new MFXButton("Click Me");

        // Set button properties
        materialButton.setPrefSize(150, 50);
        materialButton.setStyle("-fx-background-color: #1976d2;");
        materialButton.setTextFill(javafx.scene.paint.Color.WHITE);

        // Add event handler
        materialButton.setOnAction(event -> {
            System.out.println("Button clicked!");
        });

        // Create a stack pane and add the button
        StackPane root = new StackPane();
        root.getChildren().add(materialButton);

        // Create the scene and set it in the primary stage
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("MaterialFX Button Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}