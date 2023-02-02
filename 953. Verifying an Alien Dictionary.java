class Solution {
    HashMap<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(order.charAt(i), i);
        }
        int n = words.length;
        for(int i=0;i<n-1;i++){
            if(!compare(words[i], words[i+1])) return false;
        }
        return true;
    }
    public boolean compare(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        boolean flag = false;
        
        for(int i=0;i< Math.min(l1,l2);i++){
            
            if(map.get(s1.charAt(i)) > map.get(s2.charAt(i))){
                return false;
            }
            if(map.get(s1.charAt(i)) != map.get(s2.charAt(i))){
                flag = true;

                break;
            }
        }
        if(!flag && l1>l2){
            return false;
        }
        return true;
    }
}
