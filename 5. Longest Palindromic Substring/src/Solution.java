public class Solution {

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

    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
