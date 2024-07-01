// Topological sorting using Kahn's algo

class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] nums : prerequisites){
            adj.get(nums[1]).add(nums[0]);
        }
        boolean[] vis = new boolean[n];

        int[] in = new int[n];

        for(int i = 0; i < n; i++){
            for(int child: adj.get(i)){
                in[child]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> tempAns = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(in[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curNode = q.poll();
            tempAns.add(curNode);
            for(int child: adj.get(curNode)){
                in[child]--;
                if(in[child] == 0){
                    q.add(child);
                }
            }
        }
        if(tempAns.size() != n) return new int[]{};
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = tempAns.get(i);
        }

        return ans;
    }
}


// Using DFS ---> Inrecursion + Stack method

class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] nums : prerequisites){
            adj.get(nums[1]).add(nums[0]);
        }
        boolean[] vis = new boolean[n];
        boolean[] inRecursion = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(adj, vis, inRecursion, i, st);
            }
        }
        if(st.size() != n) return new int[]{};

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = st.peek();
            st.pop();
        }

        return ans;
    }

    boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] inRecursion, int node, Stack<Integer> st){
        vis[node] = inRecursion[node] = true;
        for(int child: adj.get(node)){
            if(!vis[child] && dfs(adj, vis, inRecursion, child, st)){
                return true;
            } else if(inRecursion[child] == true){
                return true;
            }
        }
        st.push(node);
        inRecursion[node] = false;

        return false;
    }
}
