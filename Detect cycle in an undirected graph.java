// DFS code

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i] && isCycle(adj, vis, i, -1)){
               return true;
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, int parent){
        vis[node] = true;
        for(int curNode : adj.get(node)){
            if(curNode == parent) continue;
            if(vis[curNode]) return true;
            if(isCycle(adj, vis, curNode, node)){
                return true; 
            }
        }
        return false;
    }
}


// BFS code

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i] && isCycle(adj, vis, i)){
               return true;
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node, -1});
        vis[node] = true;
        
        while(!q.isEmpty()){
            int[] pair = q.peek();
            q.poll();
            int src = pair[0], parent = pair[1];
            
            for(int curNode : adj.get(src)){
                if(!vis[curNode]){
                    vis[curNode] = true;
                    q.add(new int[]{curNode, src});
                }else if(curNode != parent){
                    return true;
                }
            }
        }
        return false;
    }
}

// BFS anothor approach using parent array 

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n];
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                if(bfs(adj, vis, i, parent)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int curNode, int[] parent){
        Queue<Integer> q = new LinkedList<>();
        parent[curNode] = -1;
        q.add(curNode);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            vis[cur] = true;
            for(int neighbour : adj.get(cur)){
                if(neighbour == parent[cur]) continue;
                if(vis[neighbour]) return true;
                q.add(neighbour);
                parent[neighbour] = cur;
            }
        }
        return false;
    }
}
