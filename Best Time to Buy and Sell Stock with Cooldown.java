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
