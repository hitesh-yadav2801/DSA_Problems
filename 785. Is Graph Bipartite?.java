class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++){
            if(color[i] == 1 || color[i] == -1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : graph[cur]){
                    if(color[next] == 0){
                        color[next] = -color[cur];
                        q.add(next);
                    }
                    if(color[next] == color[cur]) return false;
                }
            }
        }
        return true;
    }
}
