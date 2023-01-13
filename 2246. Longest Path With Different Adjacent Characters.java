class Solution {
    int result;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        result = 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=1;i<n;i++){
            adj.get(i).add(parent[i]);
            adj.get(parent[i]).add(i);
        }
        dfs(adj, 0, -1, s);
        return result;
    }
    private int dfs(ArrayList<ArrayList<Integer>> adj, int index, int parent, String s){
        int longest = 0;
        int secondLongest = 0;

        for(int child : adj.get(index)){
            if(child == parent) continue;

            int childLongest = dfs(adj, child, index, s);
            if(s.charAt(child) == s.charAt(index)) continue;

            if(childLongest > longest){
                secondLongest = longest;
                longest = childLongest;
            } else if(childLongest > secondLongest){
                secondLongest = childLongest;
            }
        }
        result = Math.max(result, longest + secondLongest + 1);

        return longest + 1;
    }
}
