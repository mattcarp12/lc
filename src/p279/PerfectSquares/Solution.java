package p279.PerfectSquares;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int level = 0;
        queue.offer(n);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int val = queue.poll();
                for (int j = 1; j <= Math.sqrt(val); j++) {
                    if (val - j*j == 0) return level;
                    queue.offer(val - j*j);
                }
            }
        }
        return level;
    }
}