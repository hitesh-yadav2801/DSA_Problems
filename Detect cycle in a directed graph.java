

/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
       boolean[] vis = new boolean[n];
       boolean[] curStack = new boolean[n];
       
       for(int i = 0; i < n; i++){
           if(!vis[i]){
               if(isCycleDFS(adj, i, vis, curStack)){
                   return true;
               }
           }
       }
       return false;
    }
    public boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, boolean[] curStack){
        vis[node] = curStack[node] = true;
        for(int curNode : adj.get(node)){
            if(!vis[curNode]){
                if(isCycleDFS(adj, curNode, vis, curStack) == true){
                    return true;
                }
            } else if(curStack[curNode] == true){
                return true;
            }
        }
        curStack[node] = false;
        return false;
    }
}



// Using BFS Kahn's Algo



class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] in = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int child: adj.get(i)){
                in[child]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(in[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            
            for(int child: adj.get(cur)){
                in[child]--;
                if(in[child] == 0){
                    q.add(child);
                }
            }
        }
        
        return count != n;
    }
}
