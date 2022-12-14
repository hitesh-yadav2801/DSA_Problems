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

// Using DP

