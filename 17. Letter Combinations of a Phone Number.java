class Solution {
    String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", 
    "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList();
        return recurse(digits);
    }
    public List<String> recurse(String digits){
        if(digits.length() == 0){
            ArrayList<String> emptyList = new ArrayList();
            emptyList.add("");
            return emptyList;
        }
        char ch = digits.charAt(0);
        String str = digits.substring(1);
        List<String> list = recurse(str);
        List<String> myList = new ArrayList<>();
        String strforch = nums[ch - '0'];
        for(int i = 0; i < strforch.length(); i++){
            char c = strforch.charAt(i);
            for(String s : list){
                myList.add(c + s);
            }
        }
        return myList;
    }
}
