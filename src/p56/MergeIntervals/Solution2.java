package p56.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> sol = new ArrayList<>();
        sol.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int end = sol.size() - 1;
            if (intervals[i][0] <= sol.get(end)[1]) {
                if (intervals[i][1] > sol.get(end)[1]) {
                    int[] mergedInterval = new int[]{sol.get(end)[0], intervals[i][1]};
                    sol.set(end, mergedInterval);
                }
            } else {
                sol.add(intervals[i]);
            }
        }
        return sol.toArray(new int[sol.size()][2]);
    }
}
