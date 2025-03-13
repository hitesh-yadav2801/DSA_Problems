// Optimal Solution Binary search
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = lowerBound(nums, 0, n);
        int u = upperBound(nums, 0, n);
        return Math.max(l, n - u);
    }
    private int lowerBound(int[] nums, int target, int n){
        int left = 0, right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private int upperBound(int[] nums, int target, int n){
        int left = 0, right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
