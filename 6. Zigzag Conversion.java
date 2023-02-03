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
