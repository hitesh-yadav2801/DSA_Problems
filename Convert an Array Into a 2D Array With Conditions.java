class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        ans.add(temp);
        map.put(nums[0], 1);
        for(int i = 1; i < n; i++){
            if(map.containsKey(nums[i]) && ans.size() == map.get(nums[i])){
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                ans.add(newList);
                map.put(nums[i], map.get(nums[i]) + 1);
            } else if(map.containsKey(nums[i]) && ans.size() > map.get(nums[i])){
                ans.get(map.get(nums[i])).add(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                ans.get(0).add(nums[i]);
                map.put(nums[i], 1);
            }
        }
        return ans;
    }
}


