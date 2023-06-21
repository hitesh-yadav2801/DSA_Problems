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

// Binary Search

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long minCost = Long.MAX_VALUE;
        long low = Integer.MAX_VALUE;
        long high = Integer.MAX_VALUE;
        for(int i : nums){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while(low <= high){
            long mid = low + (high - low) / 2;
            long midCost = solve(nums, cost, mid);
            long midRightCost = solve(nums, cost, mid + 1);
            minCost = Math.min(midCost, midRightCost);
            if(midCost < midRightCost){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minCost;
    }
    public long solve(int[] nums, int[] cost, long x){
        long tempCost = 0l;
        for(int i = 0; i < nums.length; i++){
            tempCost += (Math.abs(x - nums[i])) * cost[i];
        }
        return tempCost;
    }
}
