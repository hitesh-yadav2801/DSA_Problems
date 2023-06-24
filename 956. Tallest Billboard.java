class Solution {
    int dp[][];
    public int tallestBillboard(int[] rods) {
        dp = new int[21][10001];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(rods, 0, 0) / 2;
    }
    private int rec(int[] rods, int idx, int diff){
        if(idx == rods.length){
            if(diff == 0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[idx][diff + 5000] != -1){
            return dp[idx][diff + 5000];
        }
        int notPicked = rec(rods, idx + 1, diff);
        int addL1 = rods[idx] + rec(rods, idx + 1, diff + rods[idx]);
        int addL2 = rods[idx] + rec(rods, idx + 1, diff - rods[idx]);

        return dp[idx][diff + 5000] = Math.max(notPicked, Math.max(addL1, addL2));
    }
}
