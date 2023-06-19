class Solution {
    public int largestAltitude(int[] gain) {
        int prefixSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < gain.length; i++){
            max = Math.max(max, prefixSum);
            prefixSum += gain[i];
        }
        max = Math.max(max, prefixSum);
        return max;
    }
}
