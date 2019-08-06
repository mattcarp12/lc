package p5.LongestPalindromicSubtring;

public class Solution {

	public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;
        int maxLength = 1;
        int maxStart = 0;
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) isPalindrome[0][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                maxLength = 2;
                maxStart = i;
                isPalindrome[1][i] = true;
            }   
        }
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start < n - length + 1; start++) {
                if (isPalindrome[length - 3][start + 1] && s.charAt(start) == s.charAt(start + length - 1)){
                    maxLength = length;
                    maxStart = start;
                    isPalindrome[length - 1][start] = true;
                }   
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("tacocat"));
	}

}
