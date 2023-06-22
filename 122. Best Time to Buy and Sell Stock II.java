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
