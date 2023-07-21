// Memo

class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(nums, 0, -1);
    }
    public int rec(int[] nums, int idx, int prevIdx){
        if(idx == nums.length) return 0;
        if(dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1 + rec(nums, idx + 1, idx);
        }
        int notTake = 0 + rec(nums, idx + 1, prevIdx);
        
        return dp[idx][prevIdx + 1] = Math.max(take, notTake);
    }
}

// Tabulation

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){             
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
