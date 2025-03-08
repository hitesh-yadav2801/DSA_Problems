class Solution {
    public int minimumRecolors(String s, int k) {
        int n = s.length();
        int curWhites = 0;
        for(int i = 0; i < k; i++){
            if(s.charAt(i) == 'W'){
                curWhites++;
            }
        }
        int min = curWhites;
        for(int i = k; i < n; i++){
            if(s.charAt(i) == 'W'){
                curWhites++;
            }
            if(s.charAt(i - k) == 'W'){
                curWhites--;
            }
            min = Math.min(min, curWhites);
        }
        return min;
    }
}
