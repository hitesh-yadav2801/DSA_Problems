class Solution{
    int dp[][];
	public int minCoins(int coins[], int n, int target) 
	{ 
	    dp = new int[n + 1][target + 1];
	    for(int[] row : dp){
	        Arrays.fill(row, -1);
	    }
	    int ans = solve(coins, n - 1, target);
	    return ans == 1000000000 ? -1 : ans;
	}
	public int solve(int coins[], int idx, int target){
	    
	    if(idx == 0){
	        if(target % coins[0] == 0) return target / coins[0];
	        else return 1000000000;
	    }
	    if(dp[idx][target] != -1){
	        return dp[idx][target];
	    }
	    int take = Integer.MAX_VALUE;
	    if(coins[idx] <= target){
	        take = 1 + solve(coins, idx, target - coins[idx]);
	    }
	    int notTake = solve(coins, idx - 1, target);
	    
	    return dp[idx][target] = Math.min(take, notTake);
	}
}
