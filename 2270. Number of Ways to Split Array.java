class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int count = 0;
        for(int i = 0; i < n - 1; i++){
            long diff = prefix[n - 1] - prefix[i];
            if(prefix[i] >= diff){
                count++;
            }
        }
        return count;
    }
}
