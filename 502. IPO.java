class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[1] - b[1]));
        for(int i = 0; i < n; i++){
            pq.add(new int[]{profits[i], capital[i]});
        }
        
        PriorityQueue<int[]> maxpq = new PriorityQueue<int[]>((a,b) -> (b[0] - a[0]));

        while((!pq.isEmpty() || !maxpq.isEmpty()) && k > 0){
            if(!pq.isEmpty() && pq.peek()[1] <= w){
                maxpq.add(pq.poll());
            } else {
                if(!maxpq.isEmpty()){
                    w += maxpq.poll()[0];
                    k--;
                } else {
                    break;
                }
            }
        }
        return w;
    }
}
