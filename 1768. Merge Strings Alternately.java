class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n1 = word1.length();
        int n2 = word2.length();
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        sb.append(word1.substring(i));
        sb.append(word2.substring(j));
        
        return sb.toString();
    }
}
