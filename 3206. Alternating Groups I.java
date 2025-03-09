class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int prev = colors[(i - 1 + n) % n];
            int next = colors[(i + 1) % n];
            int cur = colors[i];
            if(cur != prev && cur != next){
                count++;
            }
        }
        return count;
    }
}
