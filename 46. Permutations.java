class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), new HashSet<>());
        return ans;
    }
    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, Set<Integer> vis){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!vis.contains(nums[i])){
                temp.add(nums[i]);
                vis.add(nums[i]);
                backtrack(nums, ans, temp, vis);
                temp.remove(temp.size() - 1);
                vis.remove(nums[i]);
            }
        }
    }
}
