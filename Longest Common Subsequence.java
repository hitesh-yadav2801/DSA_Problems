// using recursion(Gives TLE)

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
    }
    public int lcs(String s1, String s2, int n1, int n2){
        if(n1 >= s1.length() || n2>= s2.length()){
            return 0;
        }
        if(s1.charAt(n1) == s2.charAt(n2)){
            return 1 + lcs(s1, s2, n1+1, n2+1);
        } else {
            return Math.max(lcs(s1, s2, n1+1, n2), 
            lcs(s1, s2, n1, n2+1));
        }
    }
}

// Using DP

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
