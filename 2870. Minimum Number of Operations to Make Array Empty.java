class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(freq == 1) return -1;

            if(freq % 3 == 1){
                ans += freq / 3 + 1;
            } else if(freq % 3 == 2){
                ans += (freq + 1) / 3;
            } else {
                ans += freq / 3;
            }
        }
        return ans;
    }
}
