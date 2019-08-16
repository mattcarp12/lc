package p169.MajorityElement;

import java.util.HashMap;

class Solution {
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int key = nums[i];
            if (hash.containsKey(key)) hash.put(key, hash.get(key) + 1);
            else hash.put(key, 1);
        }
        for (int key : hash.keySet()) {
            int val = hash.get(key);
            if (val > n/2) return key;
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}