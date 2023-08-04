class Solution {
    int n;
    Boolean dp[];
    public boolean wordBreak(String s, List<String> words) {
        n = s.length();
        dp = new Boolean[n];
        Set<String> set = new HashSet<>();
        for(String word : words){
            set.add(word);
        }
        return solve(0, s, set);
    }
    public boolean solve(int idx, String s, Set<String> set){
        if(idx == n){
            return true;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        if(set.contains(s)) return true;

        for(int l = 1; l <= n - idx; l++){
            String temp = s.substring(idx, idx + l); 
            if(set.contains(temp) && solve(idx + l, s, set) == true){
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}
