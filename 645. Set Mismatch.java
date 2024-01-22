class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0){
                ans[0] = Math.abs(nums[i]);
            } else {
                nums[idx] = -1 * nums[idx];
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }
}
