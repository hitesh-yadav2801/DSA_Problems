class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            pq.offer(stones[i]);
        }
        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            if(x == y){
                continue;
            } else {
                pq.offer(y - x);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
    }
}
