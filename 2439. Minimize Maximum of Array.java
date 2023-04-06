// Binary search solution


class Solution {
    public int minimizeArrayValue(int[] nums) {
        int maxR = nums[0];
        int maxL = 1;
        int n = nums.length;
        for(int i = 1; i < nums.length; i++){
            maxR = Math.max(nums[i], maxR);
        }
        int result = 0;
        while(maxL <= maxR){
            int midMax = maxL + (maxR - maxL) / 2;
            if(isValid(nums, midMax, n)){
                result = midMax;
                maxR = midMax - 1;
                System.out.println(maxR);

            } else {
                maxL = midMax + 1;
            }
        }
        return result;
    }
    private boolean isValid(int[] nums, int expMax, int n){
        long[] temp = new long[n];
        for (int i = 0; i < n; i++){
            temp[i] = (long)nums[i];
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(temp[i] > expMax){
                return false;
            }
            long buffer = (long)expMax - temp[i];
            temp[i + 1] = temp[i + 1] - buffer;
        }
        return temp[n - 1] <= expMax;
    }
}
