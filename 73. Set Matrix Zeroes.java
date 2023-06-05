class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int[] row: temp){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < n; k++){
                        temp[i][k] = 0;
                    }
                    for(int k = 0; k < m; k++){
                        temp[k][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(temp[i][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
