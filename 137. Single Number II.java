// using extra space and linear time

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(freq == 1){
                return key;
            }
        }
        return -1;
    }
}

// using bit manipulation in constant extra space

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int k = 0; k < 32; k++){
            int temp = 1 << k;
            int zeros = 0, ones = 0;
            for(int num : nums){
                if((num & temp) == 0) zeros++;
                else ones++;
            }
            if(ones % 3 == 1){
                ans = ans | (1 << k);
            }
        } 
        return ans;
    }
}
