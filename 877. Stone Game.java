// recursion + memoization


class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        rec(piles, 0, n - 1, true);
        return dp[0][n - 1] > 0;
    }
    private int rec(int[] piles, int left, int right, boolean aliceTurn){
        if(left > right) return 0;
        if(dp[left][right] != 0) return dp[left][right];

        if(aliceTurn){
            int leftPicked = piles[left] + rec(piles, left + 1, right, false);
            int rightPicked = piles[right] + rec(piles, left, right - 1, false);
            dp[left][right] = Math.max(leftPicked, rightPicked);
        } else {
            int leftPicked = piles[left] + rec(piles, left + 1, right, true);
            int rightPicked = piles[right] + rec(piles, left, right - 1, true); 
            dp[left][right] = Math.min(leftPicked, rightPicked);
        }
        return dp[left][right];
    }
}

// O(1) solution

class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
