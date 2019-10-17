package p152.MaximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) dp[j] = nums[j];
                else dp[j] = nums[j] * dp[j - 1];
                maxProduct = Math.max(maxProduct, dp[j]);
            }
        }
        return maxProduct;
    }
}
