// Using recursion(not efficient)

class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

// using dp

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
