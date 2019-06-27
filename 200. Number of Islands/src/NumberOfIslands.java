public class NumberOfIslands {
    char[][] grid;
    int count;
    DisjointSet components;
    class DisjointSet {
        private int[] nodes;
        private int[] size;
        public DisjointSet (char[][] grid) {
            nodes = new int[grid.length*grid[0].length];
            size = new int[grid.length*grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; i < grid[i].length; j++) {
                    if (grid[i][j] == '1') {nodes[i+j] = i+j; size[i+j] = 1;}
                    else {nodes[i+j] = -1; size[i+j] = 0;}
                }
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
        int count = 0;
        Dfs(i, j);
        return count;
    }

    public void Dfs(int i, int j) {
        count++;
        components.union(i, j);
        if (validIndex(i + 1, j) && !components.connected(i + 1, j) && grid[i + 1][j] == '1') Dfs(i + 1, j);
        if (validIndex(i + 1, j) && !components.connected(i + 1, j) && grid[i + 1][j] == '1') Dfs(i, j + 1);
        if (validIndex(i + 1, j) && !components.connected(i + 1, j) && grid[i + 1][j] == '1') Dfs(i, j - 1);
        if (validIndex(i + 1, j) && !components.connected(i + 1, j) && grid[i + 1][j] == '1') Dfs(i - 1, j);
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        components = new DisjointSet(grid);
        int max_islands = 0;
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (components.isRoot(i+j)){ //only search if not already part of a component
                    islands = DepthFirstSearch(i, j);
                    max_islands = Math.max(max_islands, islands);
                }
            }
        }
        return max_islands;
    }
}
