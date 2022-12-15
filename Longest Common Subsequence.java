class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
    }
    public int lcs(String s1, String s2, int n1, int n2){
        if(n1 >= s1.length() || n2>= s2.length()){
            return 0;
        }
        if(s1.charAt(n1) == s2.charAt(n2)){
            return 1 + lcs(s1, s2, n1+1, n2+1);
        } else {
            return Math.max(lcs(s1, s2, n1+1, n2), 
            lcs(s1, s2, n1, n2+1));
        }
    }
}
