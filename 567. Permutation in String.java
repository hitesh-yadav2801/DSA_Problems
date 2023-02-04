class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int length1 = s1.length();
        int length2 = s2.length();
        if(length1 > length2) return false;
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i) - 'a']++;
        }
        for(int i=0;i<length2;i++){
            count[s2.charAt(i) - 'a']--;
            if(i >= length1){
                count[s2.charAt(i -  length1) - 'a']++;
            }
            if(allZero(count)) return true;
        }
        return false;
    }
    private boolean allZero(int[] count){
        for(int i=0;i<26;i++){
            if(count[i] != 0) return false;
        }
        return true;
    }
}
