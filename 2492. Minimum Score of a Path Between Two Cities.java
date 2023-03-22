class Solution {
    int ans = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : roads){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        } 
        boolean[] vis = new boolean[n + 1];
        dfs(adj, 1, vis);
        return ans;      
    }
    void dfs(List<List<int[]>> adj, int node, boolean[] vis){
        vis[node] = true;
        for(int[] child : adj.get(node)){
            ans = Math.min(ans, child[1]);
            if(!vis[child[0]]){
                dfs(adj, child[0], vis);
            }
        }
    }
}
