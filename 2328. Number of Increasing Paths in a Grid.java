class Solution {
    int n;
    int m;
    int mod = 1000000007;
    int[][] directions = {
                {-1, 0},
        {0, -1},        {0, 1},
                {1, 0}
    };
    int[][] dp = new int[1001][1001];
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int result = 0;
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result = (result + dfs(grid, i, j)) % mod;
            }
        }
        return result;
    }
    public int dfs(int[][] grid, int i, int j){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 1;
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(isSafe(x, y) && grid[x][y] < grid[i][j]){
                ans = (ans + dfs(grid, x, y)) % mod;
            }
        }
        return dp[i][j] = ans;
    }
    public boolean isSafe(int x, int y){
        if(x >= 0 && x < n && y >= 0 && y < m){
            return true;
        }
        return false;
    }
}
