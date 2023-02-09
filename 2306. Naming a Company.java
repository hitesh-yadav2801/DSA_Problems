// Gives TLE
class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String> set = new HashSet<>();
        for(String idea : ideas){
            set.add(idea);
        }
        for(int i = 0; i < ideas.length; i++){
            for(int j = i+1; j < ideas.length; j++){
                if(i != j){
                    String fName = ideas[i].substring(0,1) + ideas[j].substring(1);
                    String lName = ideas[j].substring(0,1) + ideas[i].substring(1); 
                    if(!set.contains(fName) && !set.contains(lName)){
                        set.add(fName + " " + lName);
                        set.add(lName + " " + fName);
                    }
                }               
            }
        }
        return set.size() - ideas.length;
    }
}

// Optimal Solution

class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] set = new Set[26];
        for(int i = 0; i < 26; i++){
            set[i] = new HashSet<>();
        }
        for(String idea : ideas){
            set[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        int[][] same = new int[26][26];
        for(int i = 0; i < 26; i++){
            for(String s : set[i]){
                for(int j = i+1; j < 26; j++){
                    if(set[j].contains(s)){
                        same[i][j]++;
                    }
                }
            }
        }
        long res = 0;
        for(int i = 0; i < 26; i++){
            for(int j = i+1; j < 26; j++){
                res += (set[i].size() - same[i][j]) * 
                (set[j].size() - same[i][j]) * 2;
            }
        }
        return res;
    }
}
