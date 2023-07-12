class Solution {
    boolean dfs(int node,List<List<Integer>> adj, boolean[] vis, boolean[] curVis, boolean[] checkCycle){
        vis[node] = curVis[node] = true;
        for(int neighbor : adj.get(node)){
            if(!vis[neighbor] && dfs(neighbor, adj, vis, curVis, checkCycle)){
                return checkCycle[node] = true;
            } else if(curVis[neighbor] == true){
                return checkCycle[node] = true;
            }
        }
        curVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < graph[i].length; j++){
                list.add(graph[i][j]);
            }
            adj.add(list);
        }
        boolean[] vis = new boolean[n];
        boolean[] curVis = new boolean[n];
        boolean[] checkCycle = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, adj, vis, curVis, checkCycle);
            }
        }
        for(int i = 0; i < n; i++){
            if(!checkCycle[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}
