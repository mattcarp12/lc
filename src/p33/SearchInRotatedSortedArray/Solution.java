package p33.SearchInRotatedSortedArray;

public class Solution {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return searchHelper(nums, 0, nums.length - 1, target);
    }

    static int searchHelper(int[] nums, int left, int right, int target) {
        int median = (right + left) / 2;
        if (nums[median] == target) return median;
        if (left >= right) return -1;

        if (nums[left] <= nums[median]) {
            if (nums[left] <= target && target < nums[median])
                return searchHelper(nums, left, median - 1, target);
            else
                return searchHelper(nums, median + 1, right, target);
        } else {
            if (nums[median] < target && target <= nums[right])
                return searchHelper(nums, median + 1, right, target);
            else
                return searchHelper(nums, left, median - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int target = 1;
        int sol = search(nums, target);
    }

}
