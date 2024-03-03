class Solution {
    Boolean[][] dp;
    
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new Boolean[n + 1][n + 1];
        
        String ans = "";
        int sp = 0, maxLen = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(checkPalindrome(s, i, j)){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp + maxLen);
    }
    
    boolean checkPalindrome(String s, int i, int j){
        if(i >= j) return true;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = checkPalindrome(s, i + 1, j - 1);
        }
        return dp[i][j] = false;
    }
}
