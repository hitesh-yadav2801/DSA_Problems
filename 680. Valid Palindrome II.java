class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int j = n - 1;
        int i = 0;
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
