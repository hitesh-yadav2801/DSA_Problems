class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            } else {
                continue;
            }
        }
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for(int k = 0; k < n; k++){
            if(nums[k] == 0){
                res[j--] = nums[k];
            } else {
                res[i++] = nums[k];
            }
        }
        return res;
    }
}
