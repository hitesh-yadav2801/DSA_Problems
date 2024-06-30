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



// BFS


class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                provinces++;
                dfs(adj, vis, i);
            }
        }
        return provinces;
    }
    void dfs(List<List<Integer>> adj, boolean[] vis, int node){
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        while(!q.isEmpty()){
            int curNode = q.poll();
            vis[curNode] = true;
            for(int child: adj.get(curNode)){
                if(!vis[child]){
                    q.add(child);
                }
            }
        }
    }
}
