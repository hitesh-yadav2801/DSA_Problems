class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        rec(1, n, k, new ArrayList<>());
        return ans;
    }
    
    public void rec(int start, int n, int k, List<Integer> temp) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp)); // Create a new copy of the temp list
            return;
        }
        if(start > n){
            return;
        }
        
        // Take
        temp.add(start);
        rec(start + 1, n, k - 1, temp);
        temp.remove(temp.size() - 1);
        
        // Not take
        rec(start + 1, n, k, temp);
    }
}
