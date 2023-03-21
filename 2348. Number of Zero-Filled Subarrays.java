class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int n = nums.length;
        long len = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                len++;
            }
            if(nums[i] != 0 || i == n - 1){
                ans += (len * (len + 1)) / 2;
                len = 0;
            }
        }
        return ans;
    }
}
