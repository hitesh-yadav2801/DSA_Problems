class Solution {
    int m;
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        m = requests.length;
        return rec(requests, n, 0, 0, indegree);
    }
    public int rec(int[][] requests, int n, int count, int idx, int[] indegree){
        if(idx == m){
            for(int i = 0; i < n; i++){
                if(indegree[i] != 0) return 0;
            }
            return count;
        }
        int from = requests[idx][0];
        int to = requests[idx][1];

        // take
        indegree[from]--;
        indegree[to]++;
        int take = rec(requests, n, count + 1, idx + 1, indegree);

        // not take

        indegree[from]++;
        indegree[to]--;
        int notTake = rec(requests, n, count, idx + 1, indegree);

        return Math.max(take, notTake);
    }
}
