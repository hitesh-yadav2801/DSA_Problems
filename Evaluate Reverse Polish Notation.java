class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || 
                s.equals("/")){
                int op2 = Integer.parseInt(st.pop());
                int op1 = Integer.parseInt(st.pop());
                int ans = 0;
                if(s.equals("+")){
                    ans = op1 + op2;
                }else if(s.equals("-")){
                    ans = op1 - op2;
                }else if(s.equals("*")){
                    ans = op1*op2;
                } else if(s.equals("/")){
                    ans = op1/op2;
                }
                st.push(Integer.toString(ans));
            } else{
                 st.push(s);
            }  
        }
        return Integer.parseInt(st.peek());
    }
}
