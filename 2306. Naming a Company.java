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
