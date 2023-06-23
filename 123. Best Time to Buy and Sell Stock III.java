// Memoisation code 

class Solution {
    int n;
    int[][][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2][3];
        for(int[][] row : dp){
            for(int[] innerRow : row){
                Arrays.fill(innerRow, -1);
            }
        }
        return rec(prices, 0, 1, 2);
    }
    private int rec(int[] prices, int idx, int buy, int cap){
        if(idx == n) return 0;

        if(cap == 0) return 0;

        if(dp[idx][buy][cap] != -1){
            return dp[idx][buy][cap];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[idx] + rec(prices, idx + 1, 0, cap);
            int notTake = rec(prices, idx+1, 1, cap);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[idx] + rec(prices, idx + 1, 1, cap - 1);
            int notSell = rec(prices, idx + 1, 0, cap);
            profit = Math.max(sell, notSell);
        }
        dp[idx][buy][cap] = profit;
        return profit;
    }
}
