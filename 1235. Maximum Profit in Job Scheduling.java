class Solution {
    int n;
    int[] dp;
    public int rec(Job[] job, int idx){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int next = getNextIndex(job, idx + 1, job[idx].end);
        int taken = job[idx].profit + rec(job, next);
        int notTaken = rec(job, idx + 1);

        return dp[idx] = Math.max(taken, notTaken);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        Job[] job = new Job[n];
        for(int i = 0; i < n; i++){
            job[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(job, Comparator.comparingInt(a -> a.start));

        return rec(job, 0);
    }
    public int getNextIndex(Job[] job, int low, int curJobEnd){
        int high = n - 1;
        int result = n + 1;  // Initialized with random value(no signicifance of n + 1)
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(job[mid].start >= curJobEnd){ // we can take this job
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1; // we cannot take this job beacuse start is not greater/ equal to the end of the previous job
            }
        }
        return result;
    }
}
class Job{
    int start, end, profit;
    public Job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
