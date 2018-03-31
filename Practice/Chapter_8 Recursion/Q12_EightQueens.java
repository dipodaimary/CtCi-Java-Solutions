package Recursion;

import java.util.ArrayList;

public class Q12_EightQueens {
    static int GRID_SIZE = 8;

    public static void main(String[] args) {

    }

    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            //Found a valid placement
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col; //place queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    /*
    Check if (row1, column1) is a valid spot for same column or diagonal, we don't need to check it
    for queens in the same row because the calling placeQueen only attempts to place one queen at a time.
    We know this row is empty
     */
    private static boolean checkValid(Integer[] columns, int row1, int col1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];
            /*
            Check if (row2,col2) invalidates (row1,col1) as a queen spot
             */
            /*Check if rows have a queen in the same column
             */
            if (col1 == col2) {
                return false;
            }
            /*
            Check if the diagonal distance between the columns equals the distance between the rows, then
            they are in the same diagonal
             */
            int col_distance = Math.abs(col2 - col1);
            int row_distance = row2 - row1;
            if (col_distance == row_distance) {
                return false;
            }
        }
        return true;
    }
}
