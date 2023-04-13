class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && popped[j] == st.peek()){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}
