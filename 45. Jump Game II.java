// DP solution O(n^2) time and O(n) space

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        if(n == 1) return 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--){  
            int min = Integer.MAX_VALUE;
            for(int j=i+1;j<=Math.min(nums[i]+i, n-1);j++){
                min = Math.min(min, dp[j]);
            }
            if(min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }
}
