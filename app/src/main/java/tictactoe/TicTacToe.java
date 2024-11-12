package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/TicTacToe.fxml"));
        Scene scene = new Scene(root, 330, 440);
        primaryStage.setTitle("MaterialFX TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}