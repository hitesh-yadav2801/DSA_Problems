// Sliding Window Approach

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0, right = 0;
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
