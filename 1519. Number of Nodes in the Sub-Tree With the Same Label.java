class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            a.get(edges[i][0]).add(edges[i][1]);
            a.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(a, -1, labels, ans, 0);
        return ans;
    }

    private int[] dfs(ArrayList<ArrayList<Integer>> a, int parent, String labels, int[] ans, int index){
        int count[] = new int[26];
        for(int child : a.get(index)){
            if(child == parent){
                continue;
            }
            int[] adjCount = dfs(a, index, labels, ans, child);

            for (int i = 0; i < 26; i++) {      
                count[i] += adjCount[i];
            }
        }
        count[labels.charAt(index) - 'a']++;
        ans[index] = count[labels.charAt(index) - 'a'];
        return count; 
    }
}
