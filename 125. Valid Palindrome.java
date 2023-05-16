class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String str = sb.toString();
            int n = str.length();
            for(int i = 0; i < n / 2; i++){
                if(str.charAt(i) != str.charAt(n - i - 1)){
                    return false;
                }
            }
        return true;
    }
}
