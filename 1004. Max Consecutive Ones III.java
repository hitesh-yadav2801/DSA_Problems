class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zeros = 0, n = nums.length;
        int ans = 0;
        while(right < n){
            if(nums[right] == 0) zeros++;

            while(zeros > k){
                if(nums[left] == 0) zeros--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
