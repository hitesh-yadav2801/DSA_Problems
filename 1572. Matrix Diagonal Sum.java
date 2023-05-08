class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat[0].length;
        int row = 0, col = 0;
        for(; row <= n-col-1; row++){
            if(row != n-col-1){
                sum += mat[row][col] + mat[row][n-col-1];
                sum += mat[n-row-1][col] + mat[n-row-1][n-col-1];
            } else {
                sum += mat[row][col];
            }
            System.out.println(sum);
            col++;
        }
        return sum;
    }
}
