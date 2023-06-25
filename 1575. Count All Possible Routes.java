class Solution {
    int[][] dp;
    private static final int MOD = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        dp = new int[n][fuel + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return rec(locations, start, finish, fuel);
    }
    public int rec(int[] locations, int idx, int finish, int fuel){
        if(fuel < 0){
            return 0;
        }
        if(dp[idx][fuel] != -1){
            return dp[idx][fuel];
        }
        int ans = 0;
        if(idx == finish){
            ans += 1;
        }
        for(int i = 0; i < locations.length; i++){
            if(i != idx){
                int remFuel = fuel -Math.abs(locations[i] - locations[idx]);
                ans = (ans + rec(locations, i, finish, remFuel)) % MOD;
            }
        }
        return dp[idx][fuel] = ans;
    }
}
