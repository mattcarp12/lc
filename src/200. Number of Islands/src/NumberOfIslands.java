public class NumberOfIslands {
    char[][] grid;
    int count;
    int rows;
    int cols;
    DisjointSet components;

    NumberOfIslands() {}

    class DisjointSet {
        private int[] nodes;
        private int[] size;
        public DisjointSet (char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            nodes = new int[rows * cols];
            size = new int[rows * cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++)
                    { nodes[cols *i + j] = cols * i + j; size[cols *i + j] = 1; }
            }
        }

        private int root(int i) {
            while (i != nodes[i]) {
                nodes[i] = nodes[nodes[i]];
                i = nodes[i];
            }
            return i;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (size[i] < size[j]) {nodes[i] = j; size[j] += size[i];}
            else {nodes[j] = i; size[i] += size[j];}
        }

        public boolean isRoot(int i) {
            return i == nodes[i];
        }

    }

    public boolean validIndex(int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int DepthFirstSearch(int i, int j) {
        this.count = 0;
        Dfs(i, j);
        return this.count;
    }

    public void Dfs(int i, int j) {
        this.count++;
        if (validIndex(i + 1, j) && !components.connected(cols*i + j, cols*(i + 1) + j) && grid[i + 1][j] == '1')
            {this.components.union(cols*i + j, cols*(i + 1) + j); Dfs(i + 1, j);};
        if (validIndex(i, j + 1) && !components.connected(cols*i + j, cols*i + j + 1) && grid[i][j + 1] == '1')
            {this.components.union(cols*i + j, cols*i + j + 1); Dfs(i, j + 1);};
        if (validIndex(i, j - 1) && !components.connected(cols*i + j, cols*i + j - 1) && grid[i][j - 1] == '1')
            {this.components.union(cols*i + j, cols*i + j - 1); Dfs(i, j - 1);};
        if (validIndex(i - 1, j) && !components.connected(cols*i + j, cols*(i - 1) + j) && grid[i - 1][j] == '1')
            {this.components.union(cols*i + j, cols*(i - 1) + j); Dfs(i - 1, j);};
    }

    public int numIslands(char[][] grd) {
        this.grid = grd;
        components = new DisjointSet(grid);
        int max_islands = 0;
        int islands = 0;
        int counter = 0;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (components.isRoot(cols*i+j) && grid[i][j] == '1'){ //only search if not already part of a component
                    islands = DepthFirstSearch(i, j);
                    //max_islands = Math.max(max_islands, islands);
                    counter++;

                }
            }
        }
        //return max_islands;
        return counter;
    }

    public static void main(String[] args) {
        //char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        NumberOfIslands test = new NumberOfIslands();
        int count = test.numIslands(grid);
    }
}
