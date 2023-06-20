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

// Prefix sum solution

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if(k == 0) return nums;
        int len = 2 * k + 1;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if(n < len){
            return ans;
        }
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for(int i = k; i < n - k; i++){
            int left = i - k;
            int right = i + k;
            long sum = prefixSum[right];
            if(left > 0){
                sum -= prefixSum[left - 1];
            }
            int avg = (int)sum / len;
            ans[i] = avg;
        }
        return ans;
    }
}
