package p268.MissingNumber;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Solution {
    public static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int missing = 0;
        for (int i : nums) set.add(i);
        for (int i = 0; i < nums.length + 1; i++)
            if (!set.contains(i))
                missing = i;
        return missing;
    }

    public static int missingNumber2(int[] nums) {
        /** Efficient Solution **/
        int total = nums.length;
        for (int i = 0; i < nums.length; i++) {
            total += i;
            total -= nums[i];
        }
        return total;
    }


    public static void main(String[] args) {
        int n = 100;
        int missing = new Random().nextInt(n);
        int[] nums = new int[n - 1];
        for (int i = 0; i < missing; i++) nums[i] = i;
        for (int i = missing + 1; i < n - 1; i++) nums[i] = i;
        System.out.println("The missing number is: " + missing + ", and the solution is " + missingNumber(nums));
        System.out.println("The missing number is: " + missing + ", and the solution is " + missingNumber2(nums));

    }
}