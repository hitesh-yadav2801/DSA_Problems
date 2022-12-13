class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j] = matrix[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j] + 
                    Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                else if(j==n-1){
                    dp[i][j] = matrix[i][j] +
                    Math.min(dp[i+1][j], dp[i+1][j-1]);
                } else{
                    dp[i][j] = matrix[i][j] +
                    Math.min(Math.min(dp[i+1][j], 
                    dp[i+1][j-1]), dp[i+1][j+1]);
                }
            }
        }
        for(int j=0;j<n;j++){
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }
}
