class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] vis = new int[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), vis);
        return ans;
    }
    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, int[] vis){
        if(temp.size() == nums.length){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(vis[i] == 0){
                temp.add(nums[i]);
                vis[i] = 1;
                backtrack(nums, ans, temp, vis);
                temp.remove(temp.size() - 1);
                vis[i] = 0;
            } 
        }
    }
}

//
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] vis = new int[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), vis);
        return ans;
    }
    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, int[] vis){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(vis[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && vis[i - 1] == 0)){
                continue;
            }
            temp.add(nums[i]);
            vis[i] = 1;
            backtrack(nums, ans, temp, vis);
            temp.remove(temp.size() - 1);
            vis[i] = 0;
        }
    }
}

