//Binary search

class Solution {
    public int searchInsert(int[] nums, int target) {
      int l = 0;
      int r = nums.length-1;
       return binarySearch(nums, l, r, target);  
    }
    
     private int binarySearch(int[] nums, int l, int r, int target){
        if(r >= l){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(target > nums[mid]){
                return binarySearch(nums, mid+1, r, target);
            } else if(target < nums[mid]){
                return binarySearch(nums,l,mid-1,target);
            }
        }
         return l;
    }
}
