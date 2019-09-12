package p48.RotateImage;

class Solution {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - i * 2 - 1; j++) {

                // top left to top right
                int temp1 = matrix[i][n - i - 1];
                matrix[i][n - i - 1] = matrix[i][j];

                // top right to bottom right
                int temp2 = matrix[n - i - 1][n - i - 1];
                matrix[n - i - 1][n - i - 1] = temp1;

                // bottom right to bottom left
                temp1 = matrix[n - i - 1][i];
                matrix[n - i - 1][i] = temp2;

                // bottom left to top left
                matrix[i][j] = temp1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(matrix.toString());
    }
}