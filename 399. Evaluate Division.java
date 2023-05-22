class Solution {
    int n;
    private void dfs(String src, String dest, HashMap<String, HashMap<String, Double>> adj, HashSet<String> vis, double[] ans, double temp){
        if(vis.contains(src)){
            return;
        } 
        vis.add(src);
        if(src.equals(dest)){
            ans[0] = temp;
            return;
        }
        for(Map.Entry<String, Double> entry : adj.get(src).entrySet()){
            String s = entry.getKey();
            double val = entry.getValue();
            dfs(s, dest, adj, vis, ans, temp * val);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        n = equations.size();
        HashMap<String, HashMap<String, Double>> adj = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(!adj.containsKey(src) || !adj.containsKey(dest)){
                finalAns[i] = -1.0;
            } else {
                HashSet<String> vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(src, dest, adj, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }
        return finalAns;
    }
    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values){

        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();

        for(int i = 0; i < n; i++){
            String u = equations.get(i).get(0); //dividend
            String v = equations.get(i).get(1); // divisor
            double value = values[i]; //   u / v

            adj.putIfAbsent(u, new HashMap<>());
            adj.putIfAbsent(v, new HashMap<>());
            adj.get(u).put(v, value);
            adj.get(v).put(u, 1.0 / value);
        }
        return adj;
    }
}
