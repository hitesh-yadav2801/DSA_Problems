// Recursion + memo
class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        dp = new int[n];
        Arrays.fill(dp, -1);
        int take_0th_house = solve(nums, 0, n - 2);
        Arrays.fill(dp, -1);
        int not_take_0th_house = solve(nums, 1, n - 1);

        return Math.max(take_0th_house, not_take_0th_house);

    }
    int solve(int[] nums, int idx, int n){
        if(idx > n){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int rob = nums[idx] + solve(nums, idx + 2, n);
        int not_rob = solve(nums, idx + 1, n);

        return dp[idx] = Math.max(rob, not_rob);
    }
}

// Tabulation


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i < n; i++){
            int rob = dp[i - 2] + nums[i - 1];
            int not_rob = dp[i - 1];
            dp[i] = Math.max(rob, not_rob);
        }
        int take_0th = dp[n - 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            int rob = dp[i - 2] + nums[i - 1];
            int not_rob = dp[i - 1];
            dp[i] = Math.max(rob, not_rob);
        }
        int not_take_0th = dp[n];

        return Math.max(take_0th, not_take_0th);
    }
}
