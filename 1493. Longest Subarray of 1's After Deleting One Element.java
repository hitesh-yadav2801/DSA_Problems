// Brute force

class Solution {
    int n;
    public int longestSubarray(int[] nums) {
        n = nums.length;
        int ans = 0;
        int zeros = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zeros++;
                ans = Math.max(ans, findMax(nums, i));
            }
        }
        if(zeros == 0) return n - 1;
        return ans;
    }
    private int findMax(int[] nums, int skipIdx){
        int curLen = 0;
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            if(i == skipIdx){
                continue;
            }
            if(nums[i] == 1){
                curLen++;
                maxLen = Math.max(curLen, maxLen);
            } else {
                curLen = 0;
            }
        }
        return maxLen;
    }
}
