package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;

public class TicTacToe extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.setProperty("prism.lcdtext", "false");
        Parent root = FXMLLoader.load(getClass().getResource("fxml/TicTacToe.fxml"));
        Scene scene = new Scene(root, 330, 440);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("favicon.png")));
        primaryStage.setTitle("MaterialFX TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Handle text size
        root.styleProperty().bind(Bindings.concat(
            "-fx-font-size: ",
            scene.widthProperty().add(scene.heightProperty()).divide(50)
        ));
    }
}