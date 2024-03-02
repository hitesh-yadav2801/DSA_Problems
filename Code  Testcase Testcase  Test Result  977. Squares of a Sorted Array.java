class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] ans = new int[nums.length];
        int ptr = nums.length - 1;
        while(i != j){
            int leftSq = nums[i] * nums[i];
            int rightSq = nums[j] * nums[j];
            if(leftSq > rightSq){
                ans[ptr--] = leftSq;
                i++;
            } else {
                ans[ptr--] = rightSq;
                j--;
            }
        }
        ans[0] = nums[i] * nums[i];
        return ans;
    }
}
