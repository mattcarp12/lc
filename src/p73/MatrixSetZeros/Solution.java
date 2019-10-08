package p73.MatrixSetZeros;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        printMatrix(matrix);
        // first DFL, set row/column marker to -1 if contains 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        printMatrix(matrix);
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] != 0) matrix[i][j] = 0;
                }
            }
        }
        printMatrix(matrix);
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    if (matrix[j][i] != 0) matrix[j][i] = 0;
                }
            }
        }
        printMatrix(matrix);
        // scan first row, if any zeros set entire row to zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][0] = 0;
                }
                break;
            }
        }
        printMatrix(matrix);
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
                break;
            }
        }
        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("------------------------------------");
    }
}
