class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int curSum = 0;
        map.put(curSum, 1);

        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            int diff = curSum - goal;
            if(map.containsKey(diff)){
                ans += map.get(diff);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return ans;
    }
}
