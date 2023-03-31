class Solution {
    HashMap<String, Boolean> map = new HashMap<>();  
    public boolean isScramble(String s1, String s2) {
        return rec(s1, s2);
    }
    private boolean rec(String s1, String s2){
        if(s1.equals(s2)){
            return true;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        int n = s1.length();

        String key = s1 + " " + s2;
        if(map.containsKey(key)){
            return map.get(key);
        }
        for (int i = 1; i < n; i++){
            boolean swapped = rec(s1.substring(0, i), s2.substring(n - i)) &&
            rec(s1.substring(i), s2.substring(0, n - i));
            
            if(swapped == true){
                map.put(key, true);
                return true;
            }

            boolean notSwapped = rec(s1.substring(0, i), s2.substring(0, i)) &&
            rec(s1.substring(i), s2.substring(i));
            
            if(notSwapped == true) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
