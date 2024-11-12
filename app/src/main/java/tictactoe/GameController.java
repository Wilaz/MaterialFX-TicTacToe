package tictactoe;

import java.util.Arrays;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameController {
    private char player = 'X';
    private char[][] game = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};
    private int[][][] wins = {
        {{0,0},{1,0},{2,0}}, // Columns
        {{0,1},{1,1},{2,1}},
        {{0,2},{1,2},{2,2}},
        {{0,0},{0,1},{0,2}}, // Rows
        {{1,0},{1,1},{1,2}},
        {{2,0},{2,1},{2,2}},
        {{0,0},{1,1},{2,2}}, // Diagonals
        {{0,2},{1,1},{2,0}}
    };
    private boolean win = true;
    private boolean won = false;

    @FXML private Label     turnLabel;
    @FXML private GridPane  grid;

    @FXML protected void handleInput(ActionEvent event) {
        MFXButton button = (MFXButton) event.getSource();

        if (button.getText().equals("") && !won) {

            Node source = (Node) event.getSource();

            Integer x   = GridPane.getColumnIndex(source);
            Integer y   = GridPane.getRowIndex(source) - 1;

            game[x][y]  = player;
            button.setText(String.valueOf(player));
            checkWin(x, y, player);

            if (!won) {
                swap();
                turnLabel.setText(String.valueOf(player) + "'s turn");
            }

        }
    }

    private void swap() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
    }

    private void checkWin(int x, int y, char player) {

        for (int[][] rows : wins) {
            win = true;
            for (int[] column : rows) {
                if (game[column[0]][column[1]] != player) {
                    win = false;
                }
            }
            if (win == true){
                handleWin(rows, player);
            }
        }
    }


    private void handleWin(int[][] tiles, char player) {
        won = true;
        turnLabel.setText("Player " + String.valueOf(player) + " wins!");

        for (int[] tile : tiles) {
            MFXButton button = (MFXButton) getNodeByRowColumnIndex(tile[0], tile[1] + 1, grid);
            button.setId("win");
        }
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == column && gridPane.getColumnIndex(node) == row) {
                result = node;
                break;
            }
        }

        return result;
    }
}