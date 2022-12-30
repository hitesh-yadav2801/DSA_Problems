class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int d = graph.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     ans.add(new ArrayList<Integer>());
        // }
        dfs(graph, 0, ans, temp);
        return ans;
    }
    public void dfs(int[][] graph, int s, List<List<Integer>> ans, List<Integer> temp){
        temp.add(s);
        if(s == graph.length-1){
            ans.add(new ArrayList(temp));
        } else {
            for(int i : graph[s]){
                dfs(graph, i, ans, temp);
            }
        }
        temp.remove(temp.size()-1);
    }
}
