// Using DFS

class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        } 
        boolean[] vis = new boolean[n];
        long remNodes = n; 
        long result = 0;
        for (int i = 0; i < n; i++){
            if(!vis[i]){
                long size = 0;
                size=dfs(i, adj, vis);
                //System.out.println(size);
                result += (size) * (remNodes - size);
                //System.out.println(result);
                remNodes -= size;
            }
        }
        return result;
    }
    private long dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        long size=1;
        for (int child : adj.get(node)){
            if(!vis[child]){
                size+=dfs(child, adj, vis);
            }
        }
        return size;
    }
}


// By using DSU


class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = 0l;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 0);
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, rank);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int i_parent = find(i, parent);
            map.put(i_parent, map.getOrDefault(i_parent, 0) + 1);
        }
        int remSize = n;
        for(int key: map.keySet()){
            int componentSize = map.get(key);
            System.out.println(componentSize);
            ans += (long)componentSize * (remSize - componentSize);
            remSize -= componentSize;
        }
        return ans;
    }
    int find(int i, int[] parent){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }
    void union(int i, int j, int[] parent, int[] rank){
        int x_parent = find(i, parent);
        int y_parent = find(j, parent);
        if(x_parent == y_parent) return;
        
        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        } else if(rank[y_parent] < rank[x_parent]){
            parent[y_parent] = x_parent;
        } else {
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }
}
