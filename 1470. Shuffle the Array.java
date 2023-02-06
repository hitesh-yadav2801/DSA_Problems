//using extra space

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int j =0;
        for(int i=0; i<nums.length; i+=2){
            ans[i] = nums[j];
            ans[i+1] = nums[j+n];
            j++;
        }
        return ans;
    }
}

// withiout using extra space

class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i < n; i++){
            nums[i] += nums[i + n] * 10000;
        }
        for(int i = n - 1; i >= 0; i--){
            nums[2 * i + 1] = nums[i] / 10000;
            nums[2 * i] = nums[i] % 10000;
             
        }
        return nums;
    }
}
