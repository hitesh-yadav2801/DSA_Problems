class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] s = path.split("/");
        for(String str : s){
            if(str.equals(".") || str.equals("")) continue;
            if(!str.equals("..")) st.push(str);
            else {
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        if(st.isEmpty()) return "/";
        String ans = "";
        while(!st.isEmpty()){
            ans = "/" + st.pop() + ans;
        }
        return ans;
    }
}
