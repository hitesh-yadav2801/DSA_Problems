class Solution {
    static final int MOD = 1000000007;

    // Top-Down Approach (Memoization)
    static long topDown(int n) {
        long[] memo = new long[n + 1];
        return topDownHelper(n, memo);
    }

    private static long topDownHelper(int n, long[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = (topDownHelper(n - 1, memo) + topDownHelper(n - 2, memo)) % MOD;
        return memo[n];
    }

    // Bottom-Up Approach (Tabulation)
    static long bottomUp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
