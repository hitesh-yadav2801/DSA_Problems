// Brute force

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int minHeight = n;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            int curHeight = 0;
            int[] maxHeightCurTree = {0};
            getHeightDfs(adj, vis, i, curHeight, maxHeightCurTree);
            if(maxHeightCurTree[0] < minHeight){
                minHeight = maxHeightCurTree[0];
                ans.removeAll(ans);
                ans.add(i);
            } else if(maxHeightCurTree[0] == minHeight){
                ans.add(i);
            }
        }
        return ans;
    }
    public void getHeightDfs(List<List<Integer>> adj, boolean[] vis, int node, int curHeight, int[] maxHeightCurTree){
        vis[node] = true;
        maxHeightCurTree[0] = Math.max(maxHeightCurTree[0], curHeight);
        for(int child : adj.get(node)){
            if(!vis[child]){
                getHeightDfs(adj, vis, child, curHeight + 1, maxHeightCurTree);
            }
        }
        vis[node] = false;
    }
}
