class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] sortedTasks = new int[n][3];
        for(int i=0;i<n;i++){
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int curTime = 0;
        int idx = 0;
        int i = 0;
        while(idx < n || pq.size() > 0){
            if(pq.isEmpty() && curTime < sortedTasks[idx][0]){
                curTime = sortedTasks[idx][0];
            }
            while(idx < n && sortedTasks[idx][0] <= curTime){
                pq.add(sortedTasks[idx]);
                idx++;
            }
            int[] temp = pq.peek();
            pq.poll();
            curTime += temp[1];
            ans[i] = temp[2];
            i++;
        }
        return ans;
    }
}
