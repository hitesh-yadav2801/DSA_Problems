class Solution {
    public int countOdds(int low, int high) {
        int range = high - low;
        if(low % 2 == 0 && high % 2 == 0){
            return range / 2;
        } 
        return range / 2 + 1;
    }
}
