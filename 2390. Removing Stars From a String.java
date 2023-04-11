class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            char c = st.pop();
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
