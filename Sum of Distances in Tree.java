class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> a = 
        new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int[] i: edges){
            a.get(i[0]).add(i[1]);
            a.get(i[1]).add(i[0]);
        }
        int[] count = new int[n];
        Arrays.fill(count, 1);

        int[] ans = new int[n];
        dfs(a, count, ans, 0, -1);
        dfs2(a, count, ans, 0, -1);
        return ans;
    }
    static void dfs(ArrayList<ArrayList<Integer>> a, int[] count, int[] ans,  int node, int parent){
         for(int child: a.get(node)){
             if(parent != child){
                 dfs(a, count, ans, child, node);
                 count[node] += count[child];
                 ans[node] += ans[child] + count[child];
             }
         }
    }

    static void dfs2(ArrayList<ArrayList<Integer>> a, int[] count, int[] ans,  int node, int parent){
         for(int child: a.get(node)){
             if(parent != child){
                 ans[child] = ans[node] - count[child] + 
                 count.length - count[child];
                 dfs2(a, count, ans, child, node);
                 
             }
         }
    }
}
