class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int i = pair[0];
            int j = pair[1];
            for(int[] dir : directions){
                int x = i + dir[0];
                int y = j + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1){
                    ans[x][y] = 1 + ans[i][j];
                    q.offer(new int[]{x, y});
                }
            }
        }
        return ans;
    }
}
