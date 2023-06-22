// Recursion + Memoisation

class Solution {
    int n;
    int[][] dp;

    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(prices, 0, true);
    }

    private int rec(int[] prices, int idx, boolean buy) {
        if (idx == n)
            return 0;

        if (dp[idx][buy ? 1 : 0] != -1)
            return dp[idx][buy ? 1 : 0];

        int profit = 0;
        if (buy) {
            int bought = -prices[idx] + rec(prices, idx + 1, false);
            int skip = rec(prices, idx + 1, true);
            profit = Math.max(bought, skip);
        } else {
            int sold = prices[idx] + rec(prices, idx + 1, true);
            int skip = rec(prices, idx + 1, false);
            profit = Math.max(sold, skip);
        }

        dp[idx][buy ? 1 : 0] = profit; // Store the computed result

        return profit;
    }
}


// Optimal Approach

class Solution {
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        int profit = 0;
        int bd = 0;
        int sd = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] >= prices[i - 1]){
                sd++;
            } else {
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        profit += prices[sd] - prices[bd];
        return profit;
    }
}
