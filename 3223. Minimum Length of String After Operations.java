class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++){
            freq[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++){
            int count = freq[i];
            if(count != 0){
                if(count % 2 == 1){
                    ans++;
                } else {
                    ans += 2;
                }
            }
            
        }
        return ans;
    }
}
