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


// O(N * 10) Time and O(N) space

class Solution {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        Map<Long, Long> map = new HashMap<>();
        map.put(0l, 1l);
        long curXor = 0;
        long result = 0;
        for(int i = 0; i < n; i++){
            curXor ^= 1 << (word.charAt(i) - 'a');
            if(map.containsKey(curXor)){
                result += map.get(curXor);
            }
            for(int j = 0; j < 10; j++){
                long tempXor = curXor ^ (1 << j);
                if(map.containsKey(tempXor)){
                    result += map.get(tempXor);
                }
            }
            map.put(curXor, map.getOrDefault(curXor, 0l) + 1l);
        }
        return result;
    }
}
