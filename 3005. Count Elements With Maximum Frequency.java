class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(nums[i]));
        }
        for(int value : map.values()){
            if(maxFreq == value){
                ans += maxFreq;
            }
        }
        return ans;
    }
}
