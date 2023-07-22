class Solution {
    Double[][][] dp;
    int n;
    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        dp = new Double[n][n][k+1];
        return rec(row, column, k);
    }
    public double rec(int r, int c, int k){
        if(r < 0 || r >= n || c < 0 || c >= n){
            return 0;
        }
        if(dp[r][c][k] != null){
            return dp[r][c][k];
        }
        if(k == 0){
            return 1;
        }
        double result = rec(r-2, c+1, k-1) + rec(r-1, c+2, k-1) + 
        rec(r+1, c+2, k-1) + rec(r+2, c+1, k-1) + rec(r+2, c-1, k-1) +
        rec(r+1, c-2, k-1) + rec(r-1, c-2, k-1) + rec(r-2, c-1, k-1);

        return dp[r][c][k] = result / 8.0;
    }
}
