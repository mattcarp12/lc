package p207.CourseSchedule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    ArrayList<Integer>[] adjList;
    boolean[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        adjList = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        boolean canFinish = true;
        for (int i = 0; i < numCourses; i++) adjList[i] = new ArrayList<Integer>();
        for (int[] edge : prerequisites) adjList[edge[1]].add(edge[0]);
        for (int i = 0; i < numCourses; i++) {
            if (canFinish == false) return false;
            if (!visited[i]) {
                canFinish = canFinish && Dfs(i, new HashSet<Integer>());
            }
        }
        return true;
    }
    
    private boolean Dfs(int node, Set<Integer> recSet) {
        visited[node] = true;
        boolean canFinish = true;
        recSet.add(node);
        for (Integer edge : adjList[node]) {
            if (recSet.contains(edge)) return false;
            if (!visited[edge]) 
                canFinish = canFinish && Dfs(edge, recSet);
        }
        recSet.remove(node);
        return canFinish;
    }
    
}