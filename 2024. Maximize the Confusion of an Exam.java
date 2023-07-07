// Sliding Window

class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int start = 0, end = 0;
        int n = s.length();
        int countT = 0, countF = 0; 
        int ans = 0;
        while(end < n){
            if(s.charAt(end) == 'T') countT++;
            else countF++;

            while(Math.min(countT, countF) > k){
                if(s.charAt(start) == 'T') countT--;
                else countF--;
                start++;
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}
