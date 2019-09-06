package p33.SearchInRotatedSortedArray;

public class Solution {

    public static int search(int[] nums, int target) {
        return searchHelper(nums, 0, nums.length - 1, target);
    }

    private static int searchHelper(int[] nums, int left, int right, int target) {
        int median = (right + left) / 2;
        if (nums[median] == target) return median;
        if (median == 0) return -1;

        if ((nums[left] > nums[median] && target >= nums[left]) ||
                (nums[left] < nums[median] && target < nums[left]))
            return searchHelper(nums, left, median - 1, target);

        if ((nums[left] > nums[median] && target < nums[left]) ||
                (nums[left] < nums[median] && target >= nums[left]))
            return searchHelper(nums, median + 1, right, target);

        return -1;
    }

}
