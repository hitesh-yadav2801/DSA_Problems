class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        boolean[] curStack = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                if(detectCycle(adj, vis, curStack, i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean detectCycle(List<List<Integer>> adj, boolean[] vis, boolean[] curStack, int node){
        vis[node] = curStack[node] = true;
        for(int curNode : adj.get(node)){
            if(!vis[curNode] && detectCycle(adj, vis, curStack, curNode)){
                return true;
            } else if(curStack[curNode] == true){
                return true;
            }
        }
        curStack[node] = false;
        return false;
    }
}
