class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        int ans = 0;
        for(char c: set){
            int i = -1;
            int j = 0;
            for(int k = 0; k < s.length(); k++){
                if(s.charAt(k) == c){
                    if(i == -1){
                        i = k;
                    }
                    j = k;
                }
            }
            Set<Character> between = new HashSet<>();
            for(int k = i + 1; k < j; k++){
                between.add(s.charAt(k));
            }
            ans += between.size();
        }
        return ans;
    }
}
