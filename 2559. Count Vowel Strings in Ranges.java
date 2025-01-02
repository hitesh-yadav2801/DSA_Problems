class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] prefix = new int[words.length + 1];

        for(int i = 1; i <= words.length; i++){
            char c1 = words[i - 1].charAt(0);
            char c2 = words[i - 1].charAt(words[i - 1].length() - 1);
            boolean isValid = isVowel(c1) && isVowel(c2);
            prefix[i] = prefix[i - 1] + (isValid ? 1 : 0);
        }

        for(int i = 0; i < n; i++){
            int low = queries[i][0];
            int high = queries[i][1];
            int count = prefix[high + 1] - prefix[low];
            
            ans[i] = count;
        }
        return ans;
    }
    boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}
