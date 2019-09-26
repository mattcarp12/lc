package p91.DecodeWays;

class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (curr != '0') dp[i] = dp[i - 1];
            if (prev != '0')
                if (Integer.parseInt("" + prev + curr) <= 26)
                    dp[i] = (i == 1) ? dp[i] + 1 : dp[i] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}