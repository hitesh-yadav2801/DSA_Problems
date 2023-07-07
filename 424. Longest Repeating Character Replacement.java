class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, ans = 0, n = s.length();
        int freq[] = new int[26];
        int maxCount = 0;
        while(right < n){
            char c = s.charAt(right);
            freq[c - 'A']++;
            maxCount = Math.max(maxCount, freq[c - 'A']);
            while((right - left + 1) - maxCount > k){
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
