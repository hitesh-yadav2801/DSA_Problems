class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            a.get(edges[i][0]).add(edges[i][1]);
            a.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(a, 0, vis, hasApple);
    }
    public static int dfs(ArrayList<ArrayList<Integer>> a, int index, boolean[] vis, List<Boolean> hasApple){
        int time = 0;
        vis[index] = true;
        for(int i : a.get(index)){
            if(!vis[i]){
                time += dfs(a, i, vis, hasApple);
            }
        }
        if(index == 0){
            return time;
        }
        if(hasApple.get(index) || time > 0){
            time += 2;
        }
        return time;
    }
}
