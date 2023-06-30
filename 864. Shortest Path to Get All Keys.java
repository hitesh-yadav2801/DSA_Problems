// Very very lengthy solution, copy pasted from youtube...can skip

class Solution {
    int[][] directions = {
                {-1, 0},
        {0, -1},        {0, 1},
                {1, 0}
    };
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        Queue<int[]> q = new LinkedList<>();
        int totalKeys = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i].charAt(j) == '@'){
                    q.add(new int[]{i, j, 0, 0});
                } else if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f'){
                    totalKeys++;
                }
            }
        }
        int final_key_status_decimal = (int)Math.pow(2, totalKeys) - 1;
        int[][][] vis = new int[m][n][final_key_status_decimal + 1];
        for(int[][] row : vis){
            for(int[] innerRow : row){
                Arrays.fill(innerRow, 0);
            }
        }
        while(!q.isEmpty()){
            int[] temp = q.peek();
            q.poll();
            int i = temp[0];
            int j = temp[1];
            int steps = temp[2];
            int current_key_status_decimal = temp[3];
            if(current_key_status_decimal == final_key_status_decimal){
                return steps;
            }
            for(int[] dir : directions){
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i].charAt(new_j) != '#'){
                    char ch = grid[new_i].charAt(new_j);
                    if(ch >= 'A' && ch <= 'F'){
                        if(vis[new_i][new_j][current_key_status_decimal] == 0 && ((current_key_status_decimal >> (ch - 'A')) & 1) == 1){
                            vis[new_i][new_j][current_key_status_decimal] = 1;
                            q.add(new int[]{new_i, new_j, steps + 1, current_key_status_decimal});
                        }
                    } else if(ch >= 'a' && ch <= 'f'){
                        int new_key_status = current_key_status_decimal | (1 << (ch - 'a'));
                        if(vis[new_i][new_j][new_key_status] == 0){
                            vis[new_i][new_j][new_key_status] = 1;
                            q.add(new int[]{new_i, new_j, steps + 1, new_key_status});
                        }
                    } else {
                        if(vis[new_i][new_j][current_key_status_decimal] == 0){
                            vis[new_i][new_j][current_key_status_decimal] = 1;
                            q.add(new int[]{new_i, new_j, steps + 1, current_key_status_decimal});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
