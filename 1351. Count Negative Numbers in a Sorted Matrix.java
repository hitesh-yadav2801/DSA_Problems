//O(n^2) solution

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = m-1; i >=0; i--){
            for(int j = n-1; j >=0; j--){
                if(grid[i][j] < 0){
                    count++;
                } else{
                    break;
                }
            }
        }
        return count;
    }
}

//O(m+n) solution

class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int i = row - 1;
        int j = 0;
        int count = 0;

        while(i >= 0 && j < col){
            if(grid[i][j] < 0){
                count += col - j;
                i--;
            } else {
                j++;
            }
        }
        return count;
    }
}
