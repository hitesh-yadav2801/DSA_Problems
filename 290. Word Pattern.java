class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();
        String[] words = s.split(" ");
        int n = pattern.length();
        if(n != words.length) return false;
        for(int i=0;i<n;i++){
            char key = pattern.charAt(i);
            if(map.containsKey(key)){
                if(map.get(key).equals(words[i])){
                    used.put(words[i], true);
                    continue;
                } else {
                    return false;
                }
            } else {
                if(!used.containsKey(words[i])){
                    map.put(key, words[i]);
                    used.put(words[i], true);
                } else if(used.containsKey(words[i])){
                    return false;
                }           
            }
        }
        return true;
    }
}
