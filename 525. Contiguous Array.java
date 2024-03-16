class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0, n = nums.length;
        map.put(0, -1);
        int ans = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                curSum += -1;
            } else {
                curSum += 1;
            }
            if(map.containsKey(curSum)){
                ans = Math.max(ans, i - map.get(curSum));
            } else {
                map.put(curSum, i);
            }
        }
        return ans;
    }
}
