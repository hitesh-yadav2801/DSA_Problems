class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0;
        boolean[][] vis = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[n-1][0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int x = q.poll();
                if(x == n*n) return steps;
                for(int k=1;k<=6;k++){
                    if(x+k > n*n) break;
                    int coordinate[] = findCoordinates(x+k, n);
                    int r = coordinate[0];
                    int c = coordinate[1];
                    if(vis[r][c] == true) continue;
                    vis[r][c] = true;
                    if(board[r][c] == -1){
                        q.add(x+k);
                    } else {
                        q.add(board[r][c]);
                    }
                }
                
            }
            steps++;
        }
        return -1;
    }
    public int[] findCoordinates(int curr, int n) {
        int r = n - (curr - 1) / n  -1;
        int c = (curr - 1) % n;
        if (r % 2 == n % 2) {
            return new int[]{r, n - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }
}
