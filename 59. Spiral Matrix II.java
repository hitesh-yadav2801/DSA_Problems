class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int dir = 0;
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int num = 1;

        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    matrix[top][i] = num++;
                }
                top++;
            }
            if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    matrix[i][right] = num++;
                }
                right--;
            }
            if(dir == 2){
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }
            if(dir == 3){
                for(int i = bottom; i >= top; i--){
                    matrix[i][left] = num++;
                }
                left++;
            }
            dir++;
            if(dir == 4){
                dir = 0;
            }
        }
        return matrix;
    }
}
