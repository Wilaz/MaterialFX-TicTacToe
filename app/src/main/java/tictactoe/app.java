package tictactoe;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.palexdev.materialfx.controls.MFXButton;
import org.palexdev.materialfx.controls.MFXLabel;
import org.palexdev.materialfx.controls.MFXTextField;

public class app extends Application {

    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private char currentPlayer = 'X';
    private MFXButton[] buttons = new MFXButton[9];

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setVgap(5);
        root.setHgap(5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int index = i * 3 + j;
                buttons[index] = new MFXButton(" ");
                buttons[index].setPrefSize(50, 50);
                buttons[index].setStyle("-fx-background-color: white;");
                buttons[index].setOnAction(event -> handleClick(index));
                root.add(buttons[index], j, i);
            }
        }

        MFXLabel turnLabel = new MFXLabel("Player X's turn");
        turnLabel.setStyle("-fx-font-size: 18px;");

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleClick(int index) {
        if (board[index / 3][index % 3] == ' ') {
            board[index / 3][index % 3] = currentPlayer;
            buttons[index].setText(String.valueOf(currentPlayer));
            buttons[index].setDisable(true);

            if (checkWin()) {
                MFXLabel result = new MFXLabel("Player " + currentPlayer + " wins!");
                result.setStyle("-fx-font-size: 18px;");
                ((Stage) result.getScene().getWindow()).setResizable(false);
                result.getScene().setRoot(result);
                result.getScene().setRoot(result);
            } else if (isBoardFull()) {
                MFXLabel result = new MFXLabel("It's a tie!");
                result.setStyle("-fx-font-size: 18px;");
                ((Stage) result.getScene().getWindow()).setResizable(false);
                result.getScene().setRoot(result);
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                turnLabel.setText("Player " + currentPlayer + "'s turn");
            }
        }
    }

    private boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}