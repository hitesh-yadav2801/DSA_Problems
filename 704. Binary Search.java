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

// Iterative solution

class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s < e){
            int mid = s + (e - s) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] > target) e = mid - 1;
            else if(nums[mid] < target) s = mid + 1;
        }
        if(nums[s] != target) return -1;
        return s;
    }
}
