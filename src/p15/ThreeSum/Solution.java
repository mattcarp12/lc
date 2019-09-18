package p15.ThreeSum;

import java.util.*;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, List<Integer>> indices = (HashMap) indices(nums);
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        int n = nums.length;
        List<List<Integer>> solutionList = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int indexInSorted = Arrays.binarySearch(numsSorted, -(nums[i] + nums[j]));
                if (indexInSorted >= 0) {
                    List<Integer> originalIndices = indices.get(numsSorted[indexInSorted]);
                    int originalIndex = getOriginalIndex(originalIndices, j);
                    if (originalIndex != -1) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[originalIndex]);
                        solutionList.add(solution);
                    }
                }
            }
        }
        return solutionList;
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
