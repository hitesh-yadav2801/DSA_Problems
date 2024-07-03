class Solution {
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0; 
        
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int node = pair[0];
            int dist = pair[1];


            /// we can remove visited array if we want
            /// visited array will optimize the solution
            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            for (ArrayList<Integer> child : adj.get(node)) {
                int adjNode = child.get(0);
                int wt = child.get(1);

                if (!visited[adjNode] && dist + wt < ans[adjNode]) {
                    ans[adjNode] = dist + wt;
                    pq.add(new int[]{adjNode, ans[adjNode]});
                }
            }
        }
        return ans;
    }
}
