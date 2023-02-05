class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        if(p.length() > s.length()){
            return list;
        }
        for(int i = 0; i < p.length(); i++){
            if(map2.containsKey(p.charAt(i))){
                map2.put(s.charAt(i), map2.get(p.charAt(i)) + 1);
            } else{
               map2.put(p.charAt(i), 1);
            }          
        }
        for(int i = 0; i < p.length(); i++){
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        int i = 0;
        int j = p.length();
        while(j < s.length()){
            if(compare(map1, map2) == true){
                list.add(i);
            }
            char addC = s.charAt(j);
            map1.put(addC, map1.getOrDefault(addC, 0) + 1);

            char removeC = s.charAt(i);
            // if(map1.containsKey(removeC)){
            //     map1.put(removeC, map1.get(removeC) - 1);
            // } else {
            //     map1.remove(removeC);
            // }
            map1.put(removeC, map1.getOrDefault(removeC, 0) - 1);
            i++;
            j++;
        }
        if(compare(map1, map2) == true){
            System.out.print(1);
                list.add(i);
            }
        return list;
    }
    public boolean compare(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
        // for(char sch : map1.keySet()){
        //     if(map2.containsKey(sch)){
        //         if(map2.get(sch) != map1.get(sch)){
        //             return false;
        //         }
        //     }
        // }
        // return true;
        return map1.equals(map2);
    }
}
