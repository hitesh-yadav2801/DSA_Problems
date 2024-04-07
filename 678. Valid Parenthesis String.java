class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[101][101];
        return solve(s, 0, 0);
    }
    boolean solve(String s, int open, int idx){
        if(idx == s.length()){
            return open == 0;
        }

        if(dp[idx][open] != null){
            return dp[idx][open];
        }

        boolean isValid = false;

        if(s.charAt(idx) == '('){
            isValid |= solve(s, open + 1, idx + 1);
        } else if(s.charAt(idx) == '*'){
            isValid |= solve(s, open + 1, idx + 1);
            isValid |= solve(s, open, idx + 1);
            if(open > 0){
                isValid |= solve(s, open - 1, idx + 1);
            }
        } else if(open > 0){
            isValid |= solve(s, open - 1, idx + 1);
        } 

        return dp[idx][open] = isValid;
    }
}
