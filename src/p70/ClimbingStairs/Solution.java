package p70.ClimbingStairs;

public class Solution {

	public static int climbStairs(int n) {
        if (n == 1) return 1;
        int step1 = 1;
        int step2 = 2;
        int temp = 0;
        for (int i = 2; i < n; i++) {
          temp = step2;
          step2 = step2 + step1;
          step1 = temp;
        } 
        return step2;
    }
	
	public static void main(String[] args) {
		System.out.println(climbStairs(20));
	}

}
