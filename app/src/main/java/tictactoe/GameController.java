package tictactoe;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameController {
    private char player     = 'X';
    private boolean win     = true;
    private boolean won     = false;
    private int moves       = 0;
    private char[][] game   = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};


    @FXML private Label     turnLabel;
    @FXML private GridPane  grid;

    @FXML protected void handleInput(ActionEvent event) {
        MFXButton button = (MFXButton) event.getSource();

        if (button.getText().equals("") && !won) {

            Node source = (Node) event.getSource();
            Integer x   = GridPane.getColumnIndex(source);
            Integer y   = GridPane.getRowIndex(source) - 1;

            moves++;
            game[x][y]  = player;
            button.setText(String.valueOf(player));
            checkWin(x, y, player);

            if (!won) {
                if (moves >= 9) {
                    tie();
                } else {
                    swap();
                    turnLabel.setText(String.valueOf(player) + "'s turn");
                }
            }
        } else if (won) {
            reset();
        }
    }

    private void swap() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
    }

    private void reset() {
        player  = 'X';
        win     = true;
        won     = false;
        moves   = 0;
        game    = new char[][] {{'-','-','-'},{'-','-','-'},{'-','-','-'}};

        turnLabel.setText(String.valueOf(player) + "'s turn");
        for (int[] tile : Constants.spots) {
            MFXButton e = (MFXButton) getNodeByRowColumnIndex(tile[0], tile[1] + 1, grid);
            e.setId("custom");
            e.setText("");
        }
    }

    private void checkWin(int x, int y, char player) {

        for (int[][] rows : Constants.wins) {
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

    private void tie() {
        won = true;
        turnLabel.setText("Tie!");

        for (int[] tile : Constants.tie) {
            MFXButton button = (MFXButton) getNodeByRowColumnIndex(tile[0], tile[1] + 1, grid);
            button.setId("win");
        }
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == column && GridPane.getColumnIndex(node) == row) {
                result = node;
                break;
            }
        }

        return result;
    }
}