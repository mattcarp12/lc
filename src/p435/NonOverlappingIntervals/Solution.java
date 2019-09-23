package p435.NonOverlappingIntervals;


import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // first sort the array
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int counter = 0;
        int lastExisting = 0;
        // Next step through to see which need to be removed
        for (int i = 1; i < intervals.length; i++) {
            // check if consecutive intervals overlap
            if (overlap(intervals[lastExisting], intervals[i])) {
                if (intervals[lastExisting][1] >= intervals[i][1]) {
                    lastExisting = i;
                }
                counter++;
            } else {
                lastExisting = i;
            }
        }
        return counter;
    }

    boolean overlap(int[] a, int[] b) {
        // only works for sorted arrays
        return b[0] < a[1];
    }
}
