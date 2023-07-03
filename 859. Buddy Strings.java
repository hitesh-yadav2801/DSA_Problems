class Solution {
    public boolean buddyStrings(String s, String g) {
        int sLen = s.length();
        int gLen = g.length();

        if(sLen != gLen) return false;

        if(s.equals(g)){
            int[] freq = new int[26];
            for(char ch : s.toCharArray()){
                freq[ch - 'a']++;
                if(freq[ch - 'a'] == 2){
                    return true;
                }
            }
            return false;
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i = 0; i < sLen; i++){
            if(s.charAt(i) != g.charAt(i)){
                ans.add(i);
                if(ans.size() > 2){
                    return false; 
                }
            }
        }
        return ans.size() == 2 && 
        s.charAt(ans.get(0)) == g.charAt(ans.get(1))  
        && s.charAt(ans.get(1)) == g.charAt(ans.get(0));
    }
}
