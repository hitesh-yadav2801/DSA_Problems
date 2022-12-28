class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = piles.length;
        for(int i=0;i<n;i++){
            pq.add(piles[i]);
        }
        while(pq.size() > 0 && k-->0){
            int temp = pq.remove();
            int dummy = temp - (int)Math.floor(temp/2);
            pq.add(dummy);
        }
        int minSum = 0;
        while(pq.size()>0){
            minSum += pq.remove();
        }
        return minSum;
    }
}


// Little bit optimized

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = piles.length;
        int minSum = 0;
        for(int i=0;i<n;i++){
            pq.add(piles[i]);
            minSum += piles[i];
        }
        while(pq.size() > 0 && k-->0){
            int temp = pq.remove();
            int dummy = temp - (int)Math.floor(temp/2);
            minSum -= (int)Math.floor(temp/2);
            pq.add(dummy);
        }
        return minSum;
    }
}
