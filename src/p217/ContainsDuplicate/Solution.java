package p217.ContainsDuplicate;

import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int key = nums[i];
            if (hash.containsKey(key)) hash.put(key, hash.get(key) + 1);
            else hash.put(key, 1);
        }
        for (int key : hash.keySet()) {
            int val = hash.get(key);
            if (val > 1) return true;
        }
        return false;
    }
}