// DFS

class Solution {
    int m, n, dirs[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxFishes = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    maxFishes = Math.max(maxFishes, dfs(grid, i, j));
                }
            }
        }
        return maxFishes;
    }
    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0){
            return 0;
        }
        int sum = grid[i][j];
        grid[i][j] = 0;
        for(int[] dir : dirs){
            int newX = i + dir[0];
            int newY = j + dir[1];
            sum += dfs(grid, newX, newY);
        }
        return sum;
    }
}
