package p217.ContainsDuplicate;

import java.util.Arrays;

/**
 * This is a simpler solution than the previous one.
 * This is O(nlogn) time and O(1) space, but the other solution
 * is O(n) time with O(n) space.
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}
