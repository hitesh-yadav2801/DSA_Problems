class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        long ans = 0;
        int i = 0, j = costs.length - 1;
        while(k > 0){
            while(pq1.size() < candidates && i <= j){
            pq1.offer(costs[i++]);
            }
            while(pq2.size() < candidates && j >= i){
                pq2.offer(costs[j--]);
            }
            int minPQ1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int minPQ2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;
            if(minPQ1 <= minPQ2){
                ans += minPQ1;
                pq1.poll();
            } else {
                ans += minPQ2;
                pq2.poll();
            }
            k--;
        }
        return ans;
    }
}
