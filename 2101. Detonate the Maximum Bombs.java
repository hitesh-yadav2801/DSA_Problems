class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long r2 = bombs[j][2];

                long distSq = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
                if(r1*r1 >= distSq){
                    adj.get(i).add(j);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int[] temp = new int[1];
            boolean[] vis = new boolean[n];
            dfs(adj, temp, vis, i);
            ans = Math.max(temp[0], ans);
        }
        return ans;
    }
    void dfs(List<List<Integer>> adj, int[] temp, boolean[] vis, int i){
        vis[i] = true;
        temp[0]++;
        for(int x : adj.get(i)){
            if(!vis[x]){
                dfs(adj, temp, vis, x);
            }
        }
    }
}
