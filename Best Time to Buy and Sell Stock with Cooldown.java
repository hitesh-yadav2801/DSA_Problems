// not a good solution


class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> map = new HashMap<>();
       return maxProfit(0, 0, prices, map); 
    }
    static int maxProfit(int i, int buySell, int[] prices, HashMap<String, Integer> map){
        if(i>= prices.length) return 0;

        String key = i + "Hitesh" + buySell;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int profit = 0;
        if(buySell == 0){
            int buy = maxProfit(i+1, 1, prices, map) - prices[i];
            int noBuy = maxProfit(i+1, 0, prices, map);
            profit = Math.max(buy , noBuy);
        } else{
            int sell = maxProfit(i+2, 0, prices, map) + prices[i];
            int noSell = maxProfit(i+1, 1, prices, map);
            profit = Math.max(sell , noSell);
        }
        map.put(key, profit);

        return profit;
    }
}

// Another memo solution


class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
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
            int sell = prices[idx] + rec(prices, idx + 2, 1);
            int notSell = rec(prices, idx + 1, 0);
            profit = Math.max(sell, notSell);
        }
        return dp[idx][buy] = profit;
    }
}
