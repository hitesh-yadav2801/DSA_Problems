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
