class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        long minCost = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long a : arr){
            pq.offer(a);
        }
        while(pq.size() > 1){
            long cost = pq.poll() + pq.poll();
            minCost += cost;
            pq.offer(cost);
        }
        
        return minCost;
    }
}
