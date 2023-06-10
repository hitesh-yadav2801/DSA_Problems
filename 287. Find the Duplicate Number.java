// using extra space and O(n) time

class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }
        for(int i = 0; i < nums.length; i++){
            if(freq[i] > 1){
                return i;
            }
        }
        return 0;
    }
}
