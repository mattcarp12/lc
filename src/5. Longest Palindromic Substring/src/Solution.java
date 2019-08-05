public class Solution {

    /**
     * This is the brute force solution.
     * For each start-end pair,
     * check if is a palindrome.
     * Runs in O(n^3) time complexity
     * and O(1) space complexity.
     *
     * @param s Input string
     * @return longest palindromic substring
     */
    public static String longestPalindromicSubstringBF(String s) {
        if (s.length() == 0) return s;
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) != s.charAt(i)) continue;
                else if (isPalindrome(s, j, i)) {
                    if (max < i - j + 1) {
                        max = i - j + 1;
                        maxStart = j;
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * Helper function for longestPalindromicSubstringBF.
     *
     * @param s - string to find longest palindrome substring in
     * @param start - starting index of string
     * @param end - ending index of string
     * @return boolean True or False whether the string is a palindrome or not.
     */
    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    /**
     * This solution uses dynamic programming (memoization).
     * The idea is to store results of previous palindromes
     * then reference those to determine future palindromes.
     * The key recurrance relation is
     * P[i][j] = P[i+1][j-1] && s.charAt(i)==s.charAt(j)
     * @param s
     * @return substring of the longest palindromic substring
     *         (this will be the first palindromic substring if
     *         there are multiple substrings with the same length).
     */
    public static String longestPalindromicSubstringDP (String s) {
        if (s.length() == 0) return s;
        int n = s.length();
        boolean P[][] = new boolean[s.length()][s.length()];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) P[j][j] = true;
                else if (j < n - i) {
                    if (i == 1) P[j][j + i] = s.charAt(j) == s.charAt(j + i);
                    else P[j][j + i] = P[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
                }
            }
        }

        int max = 0, maxStart = 0, maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (P[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

}
