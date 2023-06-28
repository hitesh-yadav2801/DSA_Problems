class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }
        double[] ans = new double[n];
        Arrays.fill(ans, 0.0);
        ans[start] = 1.0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int curNode = q.peek();
            q.poll();
            List<Pair> neighborList = adj.get(curNode);
            for(Pair pair : neighborList){
                int neighborNode = pair.node;
                double prob = pair.probability;
                double newProb = ans[curNode] * prob;
                if(newProb > ans[neighborNode]){
                    ans[neighborNode] = newProb;
                    q.offer(neighborNode);
                }
            }
        }
        return ans[end];
    }
}
class Pair{
    int node;
    double probability;
    Pair(int node,double probability){
        this.node = node;
        this.probability = probability;
    }
}
