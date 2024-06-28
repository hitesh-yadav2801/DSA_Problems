// Using DFS

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(adj, i, vis, st);
            }
        }
        for(int i = 0; i < n; i++){
            ans[i] = st.peek();
            st.pop();
        }
        return ans;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        for(int child : adj.get(node)){
            if(!vis[child]){
                dfs(adj, child, vis, st);
            }
        }
        st.push(node);
    }
}



// Using Kahn's Algo


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] inDegree = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int child: adj.get(i)){
                inDegree[child]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int idx = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            ans[idx++] = cur;
            
            for(int child : adj.get(cur)){
                inDegree[child]--;
                if(inDegree[child] == 0){
                    q.add(child);
                }
            }
        }
        
        return ans;
    }
}
