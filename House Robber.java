// Recursive solution(Gives TLE)

class Solution {
    public int rob(int[] nums) {
      return robFrom(nums, 0);  
    }
    public int robFrom(int[] nums, int curIndex){
        if(curIndex >= nums.length) return 0;
        int rob = nums[curIndex] + robFrom(nums, curIndex + 2);
        int notRob = robFrom(nums, curIndex + 1);

        return Math.max(rob, notRob);
    }
}

// Using DP Memoisation  ---> Top-down approach

class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return robFrom(nums, 0);  
    }
    public int robFrom(int[] nums, int curIndex){
        if(curIndex >= nums.length) return 0;
        if(dp[curIndex] != null) return dp[curIndex];

        int rob = nums[curIndex] + robFrom(nums, curIndex + 2);
        int notRob = robFrom(nums, curIndex + 1);

        return dp[curIndex] = Math.max(rob, notRob);
    }
}


// using tabulation ----> Bottom-up approach

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i <=n; i++){
            int rob = dp[i - 2] + nums[i - 1];
            int not_rob = dp[i - 1];
            dp[i] = Math.max(rob, not_rob);
        }
        return dp[n];
    }
}
