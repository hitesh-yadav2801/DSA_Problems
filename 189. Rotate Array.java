// Using extra space

class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            ans[k%n] = nums[i];
            k++;
        }
        System.arraycopy(ans, 0, nums, 0, n);
    }
}

// Without any extra space

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0 , n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
}
