class Solution {
    int[][] dp;
    int n;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(coins, 0, amount);
    }
    public int solve(int coins[], int idx, int target){
    
        if(idx == coins.length){
            if(target == 0) return 1;
            else return 0;
        }

        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        int take = 0;
        if(coins[idx] <= target){
            take = solve(coins, idx, target - coins[idx]);
        }
        int notTake = solve(coins, idx + 1, target);
        
        return dp[idx][target] = take + notTake;
    }
}
