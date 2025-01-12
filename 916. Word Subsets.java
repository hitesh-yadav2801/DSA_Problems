class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCharFreq = new int[26];
        int[] tempCharFreq = new int[26];

        for(String s: words2){
            Arrays.fill(tempCharFreq, 0);
            for(char c: s.toCharArray()){
                tempCharFreq[c - 'a']++;
            }
            for(int i = 0; i < 26; i++){
                maxCharFreq[i] = Math.max(maxCharFreq[i], tempCharFreq[i]);
            }
        }

        List<String> ans = new ArrayList<>();

        for(String s: words1){
            Arrays.fill(tempCharFreq, 0);
            for(char c: s.toCharArray()){
                tempCharFreq[c - 'a']++;
            }
            boolean isUniversal = true;

            for(int i = 0; i < 26; i++){
                if(tempCharFreq[i] < maxCharFreq[i]){
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal){
                ans.add(s);
            }
        }
        return ans;
    }
}
