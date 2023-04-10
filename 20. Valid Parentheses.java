class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            char temp = s.charAt(i);
            if(st.isEmpty() && (temp == ')' || temp == '}' || temp == ']')){
                return false;
            }
            if(temp == '(' || temp == '{' || temp == '['){
                st.push(temp);
            } else if(temp == ')'){
                char c = st.peek();
                if(c == '('){
                    st.pop();
                } else {
                    return false;
                }
            } else if(temp == '}'){
                char c = st.peek();
                if(c == '{'){
                    st.pop();
                } else{
                    return false;
                }
            } else if(temp == ']'){
                char c = st.peek();
                if(c == '['){
                    st.pop();
                } else {
                    return false;
                }
            } 
        }
        return st.isEmpty();
    }
}
