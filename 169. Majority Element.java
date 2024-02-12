// using HashMap

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            } 
            if(map.get(nums[i]) > nums.length/2){
                return nums[i];
            }           
        }
        return 0;
    }
}

// o(n) time and O(1) space

class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int freq = 1;
        for(int i = 1; i < nums.length; i++){
            if(freq == 0){
                ans = nums[i];
            }
            if(nums[i] == ans){
                freq++;
            } else {
                freq--;
            }
        }
        return ans;
    }
}
