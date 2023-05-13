class Solution {
    int count;
    int m = 1000000007;
    int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int len = 0;
        count = 0;
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return rec(low, high, zero, one, len);
    }
    private int rec(int low, int high, int zero, int one, int len){
        if(len > high){
            return 0;
        }
        if(dp[len] != -1){
            return dp[len];
        }
        int x = 0;
        if(len >= low && len <= high){
            x = 1;
        }
        int append_zero = rec(low, high, zero, one, len + zero);
        int append_one = rec(low, high, zero, one, len + one);

        return dp[len] = (x + append_one + append_zero) % m;
    }
}
