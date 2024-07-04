// Using recursion(not efficient)   ----> 2^n time and n space(due to recursion stack)

class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

// Using memo

class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp = new Integer[n + 1];
        return rec(n);
    }
    int rec(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(dp[n] != null){
            return dp[n];
        }
        
        return dp[n] = rec(n - 1) + rec(n - 2);
    }
}

// using dp tabulation

class Solution {
    public int climbStairs(int n) {
      if(n==1) return 1;
      int[] dp = new int[n];
      dp[n-1] = 1;
      dp[n-2] = 2;
      for(int i=n-3;i>=0;i--){
          dp[i] = dp[i+1] + dp[i+2];
      }
      return dp[0];
    }
}


// Most optimized ----> O(n) time and O(1) space


class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int prev2 = 1;
        int prev1 = 1;
        int cur = 0;
        for(int i = 2; i <= n; i++){
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}
