package p238.ProductOfArrayExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        int[] sol = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
            R[n - i - 1] = R[n - i] * nums[n - i];
        }
        for (int i = 0; i < n; i++) {
            sol[i] = L[i] * R[i];
        }
        return sol;
    }
}
