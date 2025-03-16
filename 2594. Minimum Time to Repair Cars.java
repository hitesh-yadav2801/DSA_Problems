class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        // int maxRank = Integer.MIN_VALUE;
        // for(int i = 0; i < n; i++){
        //     maxRank = Math.max(maxRank, ranks[i]);
        // }
        // long maxTime = maxRank * cars * cars;
        long l = 1l;
        long r = (long) 1e14;
        long result = 0l;
        while(l < r){
            long mid = l + (r - l) / 2;
            if(isPossible(mid, ranks, cars)){
                result = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    boolean isPossible(long time, int[] ranks, int cars){
        long sum = 0;
        for(int i = 0; i < ranks.length; i++){
            long div = time / ranks[i];
            sum += (long)Math.sqrt(div);
        }
        return sum >= cars;
    }
}
