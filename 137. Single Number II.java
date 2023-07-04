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
