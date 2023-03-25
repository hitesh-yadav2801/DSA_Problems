class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        } 
        boolean[] vis = new boolean[n];
        long remNodes = n; 
        long result = 0;
        for (int i = 0; i < n; i++){
            if(!vis[i]){
                long size = 0;
                size=dfs(i, adj, vis);
                //System.out.println(size);
                result += (size) * (remNodes - size);
                //System.out.println(result);
                remNodes -= size;
            }
        }
        return result;
    }
    private long dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        long size=1;
        for (int child : adj.get(node)){
            if(!vis[child]){
                size+=dfs(child, adj, vis);
            }
        }
        return size;
    }
}
