class Solution {
    int n;
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        n = events.length;
        dp = new int[k + 1][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        return rec(events, k, 0);
    }
    public int rec(int[][] events, int count, int idx){
        if(idx >= n || count == 0) return 0;
        if(dp[count][idx] != -1){
            return dp[count][idx];
        }
        int nextIndex = findNextIndex(events, idx + 1, events[idx][1]);
        int take = events[idx][2] + rec(events, count - 1, nextIndex);
        int notTake = rec(events, count, idx + 1);
        return dp[count][idx] = Math.max(take, notTake);
    }
    public int findNextIndex(int[][] events, int l, int curEventEnd) {
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] <= curEventEnd) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
