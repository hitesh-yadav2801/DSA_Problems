class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            int curNode = q.poll();
            ans.add(curNode);
            
            for(int neighbour : adj.get(curNode)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return ans;
    }
}
