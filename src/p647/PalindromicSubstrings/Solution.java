package p647.PalindromicSubstrings;

public class Solution {
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n + 1];
        int numPalindromes = n;

        /* Initialize for single length substrings */
        for (int i = 0; i < n; i++) isPalindrome[i][0] = isPalindrome[i][1] = true;

        /* Main double for loop */
        for (int i = 2; i < n + 1; i++) { // outer loop for length of substring
            for (int j = 0; j <= n - i; j++) { // inner loop for displacement from start of string
                if (isPalindrome[j + 1][i - 2] && s.charAt(j) == s.charAt(i + j - 1)) {
                    isPalindrome[j][i] = true;
                    numPalindromes++;
                }
            }
        }
        return numPalindromes;
    }

    public static void main(String[] args) {
        String s = "aaa";
        countSubstrings(s);
    }

}