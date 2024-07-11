class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }
        rank = new int[26];
        Arrays.fill(rank, 0);
        for(String str: equations){
            int a = str.charAt(0) - 'a';
            int b = str.charAt(3) - 'a';
            if(str.charAt(1) == '='){
                union(a, b);
            }
        }
        for(String str: equations){
            int a = str.charAt(0) - 'a';
            int b = str.charAt(3) - 'a';
            if(str.charAt(1) == '!'){
                int parentOfA = find(a);
                int parentOfB = find(b);
                if(parentOfA == parentOfB){
                    return false;
                }
            }
        }
        return true;
    }
    int find(int i){
        if(i == parent[i]) return i;

        return parent[i] = find(parent[i]);
    }
    void union(int x, int y){
        int x_par = find(x);
        int y_par = find(y);

        if(x_par == y_par) return;

        if(rank[x_par] < rank[y_par]){
            parent[x_par] = y_par;
        } else if(rank[x_par] > rank[y_par]){
            parent[y_par] = x_par;
        } else {
            parent[x_par] = y_par;
            rank[y_par]++;
        }
    }
}
