package p322.CoinChange;

class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0 || dp[i - coin] == -1) continue;
                min = Math.min(min, dp[i - coin] + 1);
            }
            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return dp[amount];
    }
}
