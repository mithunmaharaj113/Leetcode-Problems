class Solution {
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n][k + 1][2];

        // Initialize DP array with -1 (uncomputed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(0, k, prices, 1);
    }

    int solve(int i, int k, int[] prices, int canBuy) {
        if (k <= 0 || i >= prices.length) return 0;

        if (dp[i][k][canBuy] != -1) return dp[i][k][canBuy];

        if (canBuy == 1) {
            // Option 1: Buy the stock
            int buy = -prices[i] + solve(i + 1, k, prices, 0);
            // Option 2: Skip
            int notBuy = solve(i + 1, k, prices, 1);
            return dp[i][k][canBuy] = Math.max(buy, notBuy);
        } else {
            // Option 1: Sell the stock (uses 1 transaction)
            int sell = prices[i] + solve(i + 1, k - 1, prices, 1);
            // Option 2: Hold
            int hold = solve(i + 1, k, prices, 0);
            return dp[i][k][canBuy] = Math.max(sell, hold);
        }
    }
}