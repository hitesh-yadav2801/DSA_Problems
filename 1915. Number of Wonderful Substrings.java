// brute force  ---> Gives TLE

class Solution {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        long count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String s = word.substring(i, j + 1);
                if(isWonderful(s)){
                    count++;
                }
            }
        }
        return count;
    }
    boolean isWonderful(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddNums = 0;
        for(int val : map.values()){
            if(val % 2 == 1) oddNums++;
        }
        return oddNums <= 1;
    }
}
