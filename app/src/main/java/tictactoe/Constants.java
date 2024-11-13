package tictactoe;

public class Constants {
    public static final int[][][] wins  = {
        {{0,0},{1,0},{2,0}}, // Columns
        {{0,1},{1,1},{2,1}},
        {{0,2},{1,2},{2,2}},
        {{0,0},{0,1},{0,2}}, // Rows
        {{1,0},{1,1},{1,2}},
        {{2,0},{2,1},{2,2}},
        {{0,0},{1,1},{2,2}}, // Diagonals
        {{0,2},{1,1},{2,0}}
    };

    public static final int[][] tie  = {
        {1,0},  // C
        {2,0},
        {0,1},
        {1,2},
        {2,2}
    };

    public static final int[][] spots  = {
        {0,0},
        {1,0},
        {2,0},
        {0,1},
        {1,1},
        {2,1},
        {0,2},
        {1,2},
        {2,2}
    };
}
