package p200.NumberOfIslands;

public class Solution {
    int numIslands, n, m;
    boolean[][] visited;
    Solution() {
    	numIslands = n = m = 0;
    	visited = null;
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                	numIslands++;
                    Dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    
    private boolean validPoint(int i, int j) {
    	return i > -1 && i < n && j > -1 && j < m;
    }
    
    private void Dfs(char[][] grid, int i, int j) {
        visited[i][j] = true;
        if (validPoint(i + 1, j) && !visited[i + 1][j] && grid[i + 1][j] == '1') Dfs(grid, i + 1, j);
        if (validPoint(i, j + 1) && !visited[i][j + 1] && grid[i][j + 1] == '1') Dfs(grid, i, j + 1);
        if (validPoint(i - 1, j) && !visited[i - 1][j] && grid[i - 1][j] == '1') Dfs(grid, i - 1, j);
        if (validPoint(i, j - 1) && !visited[i][j - 1] && grid[i][j - 1] == '1') Dfs(grid, i, j - 1);
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	char[][] grid = {{'1','0'},{'0','1'}};
    	System.out.println(s.numIslands(grid));
    	s = null; s = new Solution();
    	char[][] grid2 = {{'1','1','0'},{'1','0','1'},{'0','1','0'}};
    	System.out.println(s.numIslands(grid2));
    }
}