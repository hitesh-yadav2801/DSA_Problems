// BFS CODE

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        ans[src] = 0;
        
        while(!q.isEmpty()){
            int curNode = q.peek();
            q.poll();
            for(int neighbor : adj.get(curNode)){
                if(ans[curNode] + 1 < ans[neighbor]){
                    ans[neighbor] = ans[curNode] + 1;
                    q.add(neighbor);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(ans[i] == Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }
        return ans;
    }
}
