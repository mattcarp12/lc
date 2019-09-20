package p55.JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int minJumps = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (minJumps > 0) {
                if (nums[i] >= minJumps) {
                    minJumps = 0;
                } else minJumps++;
            } else {
                if (nums[i] == 0) minJumps = 2;
            }
        }
        return minJumps == 0;
    }
}
