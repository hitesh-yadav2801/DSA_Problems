class Solution {
    int n;
    int[][] dp;
    int fees;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        fees = fee;
        dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(prices, 0, 1);
    }
    public int rec(int[] prices, int idx, int buy){
        if(idx >= n){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1){
            int pick = -prices[idx] + rec(prices, idx + 1, 0);
            int notPick = rec(prices, idx + 1, 1);
            profit = Math.max(pick, notPick);
        } else {
            int sell = prices[idx] - fees + rec(prices, idx + 1, 1);
            int notSell = rec(prices, idx + 1, 0);
            profit = Math.max(sell, notSell);
        }
        return dp[idx][buy] = profit;
    }
}
