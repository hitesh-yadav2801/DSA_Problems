class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> curList = new ArrayList<>();
        helper(s, curList, list);
        return list;
    }
    private void helper(String s, List<String> curList, List<List<String>> list){
        if(s.length() == 0){
            list.add(new ArrayList<String>(curList));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s, 0, i)){
                curList.add(s.substring(0, i+1));
                helper(s.substring(i+1), curList, list);
                curList.remove(curList.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int i, int j){     
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
            return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
