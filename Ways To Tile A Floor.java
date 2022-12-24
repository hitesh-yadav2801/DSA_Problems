class Solution {
    static Long numberOfWays(int N) {
        // code here
        if(N==1) return 1L;
        long n = (long)N;
        long m = 1000000007L;
        long[] dp = new long[N+1];
        dp[1] = 1L;
        dp[2] = 2L;
        for(int i =3;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i]%m;
        }
        return dp[N];
    }
}
