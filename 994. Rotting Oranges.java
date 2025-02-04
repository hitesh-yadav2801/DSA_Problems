class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = grid;
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                } else if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
        if(q.size() == 0){
            return -1;
        }
        int minutes = -1;
        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] top = q.poll();
                for(int[] dir: dirs){
                    int newX = top[0] + dir[0];
                    int newY = top[1] + dir[1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && vis[newX][newY] == 1){
                        vis[newX][newY] = 2;
                        freshOranges--;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
            minutes++;
        }
        if(freshOranges == 0){
            return minutes;
        }
        return -1;
    }
}
