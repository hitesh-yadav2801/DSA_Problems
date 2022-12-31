// recursion + memoization with HashMap
// Slow solution
class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        return path(0, 0, m-1, n-1, map);
    }
    public int path(int s1, int s2, int d1, int d2, HashMap<String, Integer> map){
        if(s1 == d1 && s2 ==d2){
            return 1;
        } 
        if(s1 > d1 || s2 > d2){
            return 0;
        }

        String key = s1 + "Hitesh" + s2;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int path1 = path(s1, s2+1, d1, d2, map);
        int path2 = path(s1+1, s2, d1, d2, map);
        map.put(key , path1 + path2);
        
        return path1 + path2;
    }
}
