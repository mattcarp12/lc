package p15.ThreeSum;

import java.util.*;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Integer>> indices = indices(nums);
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        int n = nums.length;
        Set<List<Integer>> solutionSet = new HashSet<>();
        int indexInSorted;
        int originalIndex;
        Integer[] solution;
        List<Integer> originalIndices;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                indexInSorted = Arrays.binarySearch(numsSorted, -(nums[i] + nums[j]));
                if (indexInSorted >= 0) {
                    originalIndices = indices.get(numsSorted[indexInSorted]);
                    originalIndex = getOriginalIndex(originalIndices, j);
                    if (originalIndex != -1) {
                        solution = new Integer[]{nums[i], nums[j], nums[originalIndex]};
                        Arrays.sort(solution);
                        solutionSet.add(Arrays.asList(solution));
                    }
                }
            }
        }
        return new ArrayList(solutionSet);
    }

    private static Map<Integer, List<Integer>> indices(int[] nums) {
        HashMap<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(nums[i])) {
                indices.get(nums[i]).add(i);
            } else {
                indices.put(nums[i], new ArrayList<Integer>());
                indices.get(nums[i]).add(i);
            }
        }
        return indices;
    }

    private static int getOriginalIndex(List<Integer> originalIndices, int j) {
        for (Integer k : originalIndices) {
            if (k > j) return k;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
