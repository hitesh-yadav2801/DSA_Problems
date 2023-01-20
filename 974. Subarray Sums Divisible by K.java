class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int rem = 0;
        int prefixSum = 0;
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            rem = prefixSum % k;
            if(rem < 0){
                rem = rem + k;
            }

            if(map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }
        return ans;
    }
}
