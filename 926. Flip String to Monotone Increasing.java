class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        int flipCount = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1'){
                ones++;
            } else {
                flipCount = Math.min(flipCount+1, ones);
            }
        }
        return flipCount;
    }
}
