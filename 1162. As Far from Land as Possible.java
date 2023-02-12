class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][n];
        int[][] dir = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                vis[i][j] = grid[i][j];
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        } 
        int ans = -1;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cur[] = q.poll();
                int i = cur[0];
                int j = cur[1];
                for(int[] d : dir){
                    int x = i + d[0];
                    int y = j + d[1];
                    if(x < n && x >=0 && y < n && y >=0 && vis[x][y] == 0){
                        vis[x][y] = 1;
                        q.offer(new int[]{x, y});
                    }
                }  
            }
            ans++;
        }
        return ans == 0 ? -1 : ans;
    }
}
