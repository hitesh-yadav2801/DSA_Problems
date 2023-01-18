class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int MaxCircularSum = 0;
        
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        int s = maxSubArray(nums);
        if(s < 0){
            return s;
        } else {
            MaxCircularSum = totalSum - minSubArray(nums);
        }
        return Math.max(MaxCircularSum,s);
    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int totalMax = nums[0];
        for(int i=1;i<n;i++){
            curMax = Math.max(nums[i], curMax + nums[i]);
            totalMax = Math.max(totalMax, curMax);
        }
        return totalMax;
    }
    public int minSubArray(int[] nums){
        int n = nums.length;
        int curMin = nums[0];
        int totalMin = nums[0];
        for(int i=1;i<n;i++){
            curMin = Math.min(nums[i], curMin + nums[i]);
            totalMin = Math.min(curMin, totalMin);
        }
        return totalMin;
    }
}
