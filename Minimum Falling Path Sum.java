// Recursion + memo

class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int col = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        dp = new Integer[matrix.length][matrix[0].length];
        for(int i = 0; i < col; i++){
            ans = Math.min(ans, rec(matrix, 0, i, col));
        }
        return ans;
    }
    int rec(int[][] matrix, int row, int col, int n){
        if(row == n) return 0;

        if(col < 0 || col >= n) return Integer.MAX_VALUE;

        if(dp[row][col] != null){
            return dp[row][col];
        }

        int opt1 = rec(matrix, row + 1, col - 1, n);
        int opt2 = rec(matrix, row + 1, col, n);
        int opt3 = rec(matrix, row + 1, col + 1, n);

        return dp[row][col] = matrix[row][col] + Math.min(opt1, Math.min(opt2, opt3));
    }
}

// Bottom up

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
