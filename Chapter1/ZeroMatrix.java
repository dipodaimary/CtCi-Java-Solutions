package Chapter1;

public class ZeroMatrix {
    public static void main(String[] args) {
        int size = 3;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        Zero(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Zero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (col[j]) {
                nullifyCol(matrix, j);
            }
        }
    }

    public static void nullifyRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[i][j] = 0;
        }
    }

    public static void nullifyCol(int[][] matrix, int j) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][j] = 0;
        }
    }
}
