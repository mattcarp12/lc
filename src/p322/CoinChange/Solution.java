package p322.CoinChange;

import java.util.Arrays;

public class Solution {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return (dp[amount] < amount + 1) ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int sol = coinChange(coins, amount);
    }
}