class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length, day = 0, result = 0, idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!pq.isEmpty() || idx < n){
            if(pq.isEmpty()){
                day = events[idx][0];
            }
            while(idx < n && events[idx][0] <= day){
                pq.offer(events[idx][1]);
                idx++;
            }
            pq.poll();
            day++;
            result++;
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return result;
    }
}
