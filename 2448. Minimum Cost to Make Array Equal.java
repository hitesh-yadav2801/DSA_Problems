// Brute force TLE

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long minCost = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long tempCost = 0l;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                tempCost += (Math.abs(nums[i] - nums[j])) * cost[j];
            }
            minCost = Math.min(minCost, tempCost);
        }
        return minCost;
    }
}
