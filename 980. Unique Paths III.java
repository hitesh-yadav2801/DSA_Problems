class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeros = 0;
        int startX = 0;
        int startY = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    zeros++;
                } else if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        return dfs(grid, startX, startY, zeros);
    }
    public int dfs(int[][] grid, int x, int y, int zeros){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
        grid[x][y] == -1){
            return 0;
        }
        if(grid[x][y] == 2){
            if(zeros == -1){
                return 1;
            } else {
                return 0;
            }
        }
        grid[x][y] = -1;
        zeros--;
        int totalPaths = dfs(grid,x+1, y, zeros) +
        dfs(grid,x, y+1, zeros) +
        dfs(grid,x-1, y, zeros) +
        dfs(grid,x, y-1, zeros);

        grid[x][y] = 0;
        zeros++;

        return totalPaths;

    }
}
