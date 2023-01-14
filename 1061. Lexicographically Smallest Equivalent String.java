class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
       int n = s1.length();
       int m = baseStr.length();
        ArrayList<ArrayList<Character>> adj = new ArrayList<ArrayList<Character>>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<Character>());
        } 
        for(int i=0;i<n;i++){
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            adj.get(u - 'a').add(v);
            adj.get(v - 'a').add(u);
        } 
        StringBuilder result = new StringBuilder();
        for(int i=0;i<m;i++){
            char ch = baseStr.charAt(i);
            boolean[] vis = new boolean[26];
            char minChar = dfs(adj, ch, vis);
            result.append(minChar);
        }
        
        return result.toString();
    }
    private char dfs(ArrayList<ArrayList<Character>> adj, char ch, boolean[] vis){
        vis[ch - 'a'] = true; 
        char minChar = ch;
        for(char neighbour : adj.get(ch - 'a')){
            if(!vis[neighbour - 'a']){
                char neighbourMin = dfs(adj, neighbour, vis);
                if(neighbourMin -'a' < minChar - 'a'){
                    minChar = neighbourMin;
                }
            }
        }
        return minChar;
    }
}
