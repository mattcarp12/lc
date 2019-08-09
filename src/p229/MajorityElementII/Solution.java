package p229.MajorityElementII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return new ArrayList();
        int[][] majors = {{0,0},{0,0}};
        Arrays.sort(nums);
        int n = nums.length;
        int curr = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != curr) {
                if (count > majors[0][1]) {
                    majors[0][1] = count;
                    majors[0][0] = curr;
                }
                else if (count > majors[1][1]) {
                    majors[1][1] = count;
                    majors[1][0] = curr;
                }
                curr = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (count > majors[0][1]) {
            majors[0][1] = count;
            majors[0][0] = curr;
        }
        else if (count > majors[1][1]) {
            majors[1][1] = count;
            majors[1][0] = curr;
        }

        List<Integer> list = new ArrayList();
        if (majors[0][1] > n/3) list.add(majors[0][0]);
        if (majors[1][1] > n/3) list.add(majors[1][0]);
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,2,1,1,1,2,2};
        List<Integer> list1 = majorityElement(nums1);
    }
}