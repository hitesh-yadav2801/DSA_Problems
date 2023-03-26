class Solution {
    int result = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        boolean[] inRecursion = new boolean[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, edges, vis, inRecursion, count);
            }
        }
        return result;
    }
    private void dfs(int u, int[] edges, boolean[] vis, 
    boolean[] inRecursion, int[] count){
        if(u != -1){
            vis[u] = true;
            inRecursion[u] = true;
            int v = edges[u];
            if(v != -1 && !vis[v]){
                count[v] = count[u] + 1;
                dfs(v, edges, vis, inRecursion, count);
            } else if(v != -1 && inRecursion[v] == true) {
                result = Math.max(result, count[u] - count[v] + 1);
            }
            inRecursion[u] = false;
        }
    }
}
