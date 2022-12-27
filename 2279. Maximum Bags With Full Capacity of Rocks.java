class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] vacancy = new int[n];
        for(int i=0;i<n;i++){
            vacancy[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(vacancy);
        int count = 0;
        for(int i=0;i<n;i++){
            if(additionalRocks == 0){
                break;
            }else{
                if(additionalRocks >= vacancy[i]){
                additionalRocks = additionalRocks - vacancy[i];
                count++;
                }
            }
            
        }
        return count;
    }
}
