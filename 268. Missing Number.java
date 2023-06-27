// Using sum of n natural numbers formula

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = ((n)*(n+1)) / 2;
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(expectedSum == sum) return 0;
        return expectedSum - sum;
    }
}

// Using Bit Manipulation

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = 0;
        for(int i = 0; i < n; i++){
            missing ^= i ^ nums[i];
        }
        missing ^= n;
        return missing;
    }
}
