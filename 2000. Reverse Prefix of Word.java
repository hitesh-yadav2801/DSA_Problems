class Solution {
    public String reversePrefix(String s, char ch) {
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == ch){
                StringBuilder sub1 = new StringBuilder(s.substring(0, i + 1)).reverse();
                String sub2 = s.substring(i + 1);
                String res = sub1.toString() + sub2;
                return res;
            }
        }
        return s;
    }
}
