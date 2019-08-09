package p207.CourseSchedule;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Digraph G = Digraph.makeGraph(numCourses, prerequisites);
        return !G.hasCycle();
    }
}

class Digraph {

    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private Set<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v

    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Graph must have nonnegative number of verticies.");
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        adj = (Set<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v++)
            adj[v] = new HashSet<Integer>();
    }

    public static Digraph makeGraph(int V, int[][] edges) {
        Digraph G = new Digraph(V);
        for (int[] edge : edges) {
            G.addEdge(edge[1], edge[0]);
        }
        return G;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int v = 0; v < V; v++) {
            if(!visited[v] && hasCycleDFS(visited,recStack,v))
                return true;
        }
        return false;
    }

    private boolean hasCycleDFS(boolean[] visited, boolean[] recStack, int v) {
        if (recStack[v]) return true;
        if (visited[v]) return false;
        visited[v] = true;
        recStack[v] = true;
        for(int child : adj[v])
            if(hasCycleDFS(visited, recStack, child)) return true;
        recStack[v] = false;
        return false;
    }

}
