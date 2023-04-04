// using HashSet

class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 1;
        for (int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            if(set.contains(key)){
                ans++;
                boolean flag = set.removeAll(set);
                set.add(key);
            } else {
                set.add(key);
            }
        }
        return ans;
    }
}


// using 26 size array

class Solution {
    public int partitionString(String s) {
        int ans = 1;
        int[] key = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(key[s.charAt(i) - 'a'] == 1){
                ans++;
                Arrays.fill(key, 0);
                key[s.charAt(i) - 'a'] = 1;
            } else {
                key[s.charAt(i) - 'a'] = 1;
            }
        }
        return ans;
    }
}
