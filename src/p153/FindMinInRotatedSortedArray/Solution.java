package p153.FindMinInRotatedSortedArray;

import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        // edge cases
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);

        int mid = nums.length / 2;

        // check if mid is min
        if (nums[mid - 1] > nums[mid]) return nums[mid];

        // check if min is to left
        if (nums[mid] < nums[nums.length - 1]) return findMin(Arrays.copyOfRange(nums, 0, mid));

        // otherwise min is to right
        return findMin(Arrays.copyOfRange(nums, mid + 1, nums.length));
    }
}
