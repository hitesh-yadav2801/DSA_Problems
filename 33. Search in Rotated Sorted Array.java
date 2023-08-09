class Solution {
    public int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int temp = findMin(nums);
        System.out.print(temp);
        int leftAns = binarySearch(nums, 0, temp - 1, target);
        int rightAns = binarySearch(nums, temp, n - 1, target);
        if(leftAns == -1 && rightAns == -1) return -1;
        if(leftAns != -1) return leftAns;
        return rightAns;
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
