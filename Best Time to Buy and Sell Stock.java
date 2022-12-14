// Brute force

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer. MIN_VALUE;
        int cur = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(prices[j] > prices[i]){
                    cur = prices[j] - prices[i];                   
                }  
               maxProfit = Math.max(cur,maxProfit); 
            }
        }
        if(maxProfit < 1)
            return maxProfit = 0;
        return maxProfit;
    }
}

// O(n) and O(1) space 

class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit = 0;
       int minSofar = prices[0];
        for(int i=0;i<prices.length;i++){
            minSofar = Math.min(minSofar , prices[i]);
            int profit = prices[i] - minSofar;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}
