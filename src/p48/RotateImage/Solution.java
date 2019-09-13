package p48.RotateImage;

import java.util.Arrays;

class Solution {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {

                // Store first value in temp variable
                int temp = matrix[i][j];

                // bottom right to top right
                matrix[i][j] = matrix[n - j - 1][i];

                // bottom right to bottom left
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];

                //top right to bottom right
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];

                // top left to top right
                matrix[j][n - i - 1] = temp;

            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}