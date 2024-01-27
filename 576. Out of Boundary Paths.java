class Solution {
    Long[][][] dp;
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Long[m + 1][n + 1][maxMove + 1];
        return (int)solve(m, n, maxMove, startRow, startColumn);
    }
    long solve(int m, int n, int maxMove, int row, int col){
        if(maxMove < 0) return 0;
        if(row < 0 || col < 0 || row >= m || col >= n){
            return 1;
        }

        if(dp[row][col][maxMove] != null) return dp[row][col][maxMove];

        long total = 0;
        long left = solve(m, n, maxMove - 1, row - 1, col);
        long right = solve(m, n, maxMove - 1, row + 1, col);
        long top = solve(m, n, maxMove - 1, row, col - 1);
        long bottom = solve(m, n, maxMove - 1, row, col + 1);

        total = (left + right + top + bottom) % mod;
        return dp[row][col][maxMove] = total;
    }
}
