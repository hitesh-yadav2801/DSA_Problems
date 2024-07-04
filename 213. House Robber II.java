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
