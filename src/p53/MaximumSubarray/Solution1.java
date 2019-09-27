package p53.MaximumSubarray;

public class Solution1 {
    public int maxSubArray(int[] nums) {
        int currMax, max;
        currMax = max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            if (currMax > max) max = currMax;
        }
        return max;
    }
}
