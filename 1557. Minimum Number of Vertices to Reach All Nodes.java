class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        boolean[] indegree = new boolean[n];

        for(List<Integer> child : edges){
            indegree[child.get(1)] = true;
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] == false){
                ans.add(i);
            }
        }
        return ans;
    }
}
