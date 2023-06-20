// Brute foce

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int len = 2 * k + 1;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if(n < len){
            return ans;
        }
        for(int i = k; i < n - k; i++){
            int sum = 0;
            for(int j = i - k; j <= i + k; j++){
                sum += nums[j];
            }
            int avg = sum / len;
            ans[i] = avg;
        }
        return ans;
    }
}
