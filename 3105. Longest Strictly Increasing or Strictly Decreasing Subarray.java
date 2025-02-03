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


// Optimal Apporoach O(n)

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1, decLen = 1;
        int n = nums.length;
        int max = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                incLen++;
                decLen = 1;
            } else if(nums[i] < nums[i-1]){
                decLen++;
                incLen = 1;
            } else {
                incLen = 1;
                decLen = 1;
            }
            max = Math.max(max, Math.max(incLen, decLen));
        }
        return max;
    }
}
