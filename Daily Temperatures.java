// By using extra space

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[temperatures.length];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()] <=
                temperatures[i]){
                     st.pop();
                }
            if(st.isEmpty()){
                ans[i] = 0;
            } else{
                ans[i] = st.peek() - i;
            }   
            st.push(i);        
        }
        return ans;
    }
}
