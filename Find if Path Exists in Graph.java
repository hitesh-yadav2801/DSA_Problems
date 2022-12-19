// By DFS


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            a.get(edges[i][0]).add(edges[i][1]);
            a.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(a,source,destination,vis);
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> a, int s, int d, boolean[] vis){
        if(s == d){
            return true;
        }
        if(vis[s] == true){
            return false;
        }
        vis[s] = true;
        for(int i=0;i<a.get(s).size();i++){
            if(dfs(a,a.get(s).get(i),d,vis)){
                return true;
            }
        }
        return false;
    }
}
