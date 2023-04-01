// Recursive solution

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        return rec(nums, target, start, end);
    }
    private int rec(int[] nums, int target, int start, int end){
        int mid = start + (end - start) / 2;
        if(start > end){
            return -1;
        }
        if(nums[mid] == target){
            return mid;
        } else if (target < nums[mid]){
            return rec(nums, target, start, mid - 1);
        } else {
            return rec(nums, target, mid + 1, end);
        }
    }
}
