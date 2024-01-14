class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    map.put(ch, map.get(ch) - 1);
                    System.out.println(ch + ": " + map.get(ch));
                }
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        int ans = 0;
        for(Character key : map.keySet()){
            ans += map.get(key);
        }
        return ans;
    }
}
