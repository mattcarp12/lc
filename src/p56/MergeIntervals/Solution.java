package p56.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        sortIntervals(intervals);
        return mergeIntervals(intervals);
    }

    static void sortIntervals(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            int j = i - 1;
            while (j >= 0 && intervals[j][0] > intervals[j + 1][0]) {
                int[] temp = intervals[j];
                intervals[j] = intervals[j + 1];
                intervals[j + 1] = temp;
                j--;
            }
        }
    }

    static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> sol = new ArrayList<int[]>();
        sol.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= sol.get(sol.size() - 1)[1] &&
                    intervals[i][1] > sol.get(sol.size() - 1)[1]) {
                int[] t = sol.remove(sol.size() - 1);
                sol.add(new int[]{t[0], intervals[i][1]});
            } else if (intervals[i][0] > sol.get(sol.size() - 1)[1]) {
                sol.add(intervals[i]);
            }
        }
        int[][] ret = new int[sol.size()][2];
        int n = sol.size();
        for (int i = 0; i < n; i++) ret[i] = sol.remove(0);
        return ret;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {15, 18}, {8, 10}, {2, 6}};
        merge(intervals);
    }
}
