class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long start = Long.MAX_VALUE;
        long end = 0;
        long min = Long.MAX_VALUE;
        for(int i : time){
            min = Math.min(min, i);
            start = Math.min(start, i);
        }
        end = totalTrips * min;
        while(start < end){
            long mid = start + (end - start) / 2;

            if(possible(time, mid, totalTrips)){
                end = mid;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }
    private boolean possible(int[] time, long mid, int totalTrips){
        long trips = 0;
        for(int i : time){
            trips += mid / i;
        }
        if(trips >= totalTrips)
            return true;
        return false;
    }
} 
