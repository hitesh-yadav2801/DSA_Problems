// Brute force O(n^2)

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        for(int i = 0; i < n; i++){
            int curLength = 1;
            for(int j = i + 1; j < n; j++){
                if(nums[j] > nums[j-1]){
                    curLength++;
                } else {
                    break;
                }
            }
            max = Math.max(max, curLength);
            curLength = 1;
            for(int j = i + 1; j < n; j++){
                if(nums[j] < nums[j-1]){
                    curLength++;
                } else {
                    break;
                }
            }
            max = Math.max(max, curLength);  
        }
        return max;
    }
}
