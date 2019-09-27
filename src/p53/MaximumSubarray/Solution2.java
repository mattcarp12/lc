package p53.MaximumSubarray;


/*

Idea:
Step through the array once.
At each index, determine the maximum subarray that ends at position i.
The maximum at position i+1 = max(maximum at position i + element i+1 , element i+1)
Keep a pointer to the maximum.
Also, store the left at right pointers to the subarray that ends at each element i.
*/


public class Solution2 {
    public int maxSubArray(int[] nums) {

        int[] res = new int[nums.length];
        int max_pointer = 0;

        // initialise result with index 0
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1] + nums[i], nums[i]);
            if (res[i] > res[max_pointer]) max_pointer = i;
        }

        return res[max_pointer];
    }
}
