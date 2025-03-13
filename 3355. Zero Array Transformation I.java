class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            pre[l]++;
            pre[r + 1]--;
        }
        for(int i = 1; i < n; i++){
            pre[i] += pre[i - 1];
        }
        for(int i = 0; i < n; i++){
            if(pre[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}
