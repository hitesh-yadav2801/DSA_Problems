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
