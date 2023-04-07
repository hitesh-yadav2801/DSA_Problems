class Solution {
    int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j) == true){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid, int r, int c){
        if(r >= m || r < 0 || c >=n || c < 0){
            return false;
        }
        if(grid[r][c] == 1){
            return true;
        }
        grid[r][c] = 1;
        boolean left_closed = dfs(grid, r, c - 1);
        boolean right_closed = dfs(grid, r, c + 1);
        boolean up_closed = dfs(grid, r - 1, c);
        boolean down_closed = dfs(grid, r + 1, c);

        return left_closed && right_closed && up_closed && down_closed;
    }
}
