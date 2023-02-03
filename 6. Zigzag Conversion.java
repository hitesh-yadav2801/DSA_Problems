class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for(int i = 0 ; i < numRows; i++){
            list.add(new ArrayList<>());
        }
        int index = 0;
        while(index < s.length()){
            for(int i=0;i<numRows && index < s.length();i++){
                list.get(i).add(s.charAt(index++));
            }
            for(int i= numRows -2;i>0 && index < s.length();i--){
                list.get(i).add(s.charAt(index++));
            }
        }
        StringBuilder sb = new StringBuilder(); 
        for(int i=0;i<list.size();i++){
            for(char ch : list.get(i)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

// optimized Approach

class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for(int i = 0 ; i < numRows; i++){
            list.add(new ArrayList<>());
        }
        int dir = 1;
        int curRow = 0;
        for(char ch : s.toCharArray()){
            list.get(curRow).add(ch);
            if(curRow == numRows -1){
                dir = -1;
            } else if(curRow == 0){
                dir = 1;
            }
            curRow += dir;
        }
        StringBuilder sb = new StringBuilder(); 
        for(int i=0;i<list.size();i++){
            for(char ch : list.get(i)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
