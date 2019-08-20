package p125.ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        char[] c = s.toCharArray();
        int n = c.length;
        boolean sol = true;
        for (int i = 0; i < n / 2; i++) {
            sol = sol && c[i] == c[n - i - 1];
        }
        return sol;
    }
}