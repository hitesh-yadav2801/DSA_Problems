class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 1; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if(isPrefixAndSuffix(words[j], words[i])){
                    count++;
                }
            }
        }
        return count;
    }
    boolean isPrefixAndSuffix(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if(len2 < len1){
            return false;
        } 
        return s2.startsWith(s1) && s2.endsWith(s1);
    }
}
