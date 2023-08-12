// Recursion + memo

class Solution {
    int m , n;
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n];
        return solve(grid, 0, 0);
    }
    private int solve(int[][] grid, int i, int j){
        if(i >= m || j >= n || grid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;

        if(dp[i][j] != null){
            return dp[i][j];
        }
        int path1 = solve(grid, i + 1, j);
        int path2 = solve(grid, i, j + 1);

        return dp[i][j] = path1 + path2;
    }
}

// Tabulation

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        for(int i=m-1;i>=0;i--){
            if(obstacleGrid[i][n-1] == 0){
                dp[i][n-1] = 1;
            } else {
                break;
            }           
        }
        for(int i=n-1;i>=0;i--){
            if(obstacleGrid[m-1][i] == 0){
                dp[m-1][i] = 1;
            } else {
                break;
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                } else {
                     dp[i][j] = 0;
                }
            }
        }
        return dp[0][0];
    }
}
