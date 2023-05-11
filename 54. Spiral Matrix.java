class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int dir = 0;
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        /*
        dir 0 -> left to right
        dir 1 -> top to bottom
        dir 2 -> right to left
        dir 3 -> bottom to top
        */

        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    list.add(matrix[top][i]);
                }
                top++;
            }
            if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }
            if(dir == 2){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(dir == 3){
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            if(dir == 4){
                dir = 0;
            }
        }
        return list;
    }
}
