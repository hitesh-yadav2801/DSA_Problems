// brute force
// by linear search

// better solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) i--;
            else j++;
        }
        return false;
    }
}

// Optimal solution

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int i = mid / n;
            int j = mid % n;
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
