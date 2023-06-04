class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int provinces = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(isConnected, vis, i);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int[][] isConnected, boolean[] vis, int node){
        vis[node] = true;
        for(int i = 0; i < n; i++){
            if(!vis[i] && isConnected[node][i] == 1){
                dfs(isConnected, vis, i);
            }
        }
    }
}
