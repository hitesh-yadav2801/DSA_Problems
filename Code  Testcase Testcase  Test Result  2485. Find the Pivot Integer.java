class Solution {
    public int pivotInteger(int n) {
        int i = 1, j = n;
        int leftSum = 1, rightSum = n;
        if(n == 1) return 1;
        while(i < j){
            if(leftSum < rightSum){
                leftSum += ++i;
            } else {
                rightSum += --j;
            }
            if(leftSum == rightSum && i + 1 == j - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
