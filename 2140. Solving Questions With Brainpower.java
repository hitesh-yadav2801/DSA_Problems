// used only recusion(No dp)
// gives tle
class Solution {
    public long mostPoints(int[][] questions) {
        long res = rec(questions, 0);
        return res;
    }
    private long rec(int[][] questions, int idx){
        int len = questions.length;
        if(idx >= len){
            return 0;
        }

        long taken = questions[idx][0] + 
        rec(questions, idx + questions[idx][1] + 1);
        long not_taken = rec(questions, idx + 1);

        return Math.max(taken, not_taken);
    }
}

// Using Recursion + memoisation

class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1l);
        long res = rec(questions, 0, dp);
        return res;
    }
    private long rec(int[][] questions, int idx, long[] dp){
        int len = questions.length;
        if(idx >= len){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        long taken = questions[idx][0] + 
        rec(questions, idx + questions[idx][1] + 1, dp);
        long not_taken = rec(questions, idx + 1, dp);

        dp[idx] = Math.max(taken, not_taken);

        return dp[idx];
    }
}
