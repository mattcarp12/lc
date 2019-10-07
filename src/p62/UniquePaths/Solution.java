package p62.UniquePaths;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        if (m == 1 || n == 1) return 1;

        /* Initialize bottom row and right column to all 1 */
        for (int i = 0; i < n - 1; i++) paths[m - 1][i] = 1;
        for (int i = 0; i < m - 1; i++) paths[i][n - 1] = 1;

        /* Loop through remaining cells, using results
           of previous calculations (dynamic programming) */
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                paths[j][i] = paths[j + 1][i] + paths[j][i + 1];
            }
        }
        return paths[1][0] + paths[0][1];
    }
}
