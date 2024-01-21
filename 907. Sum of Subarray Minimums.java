class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        previousSmaller(arr, prev);
        nextSmaller(arr, next);
        int mod = (int) 1e9 + 7;
        long answer = 0;

        for (int i = 0; i < n; ++i) {
            int l = i - prev[i];
            int r = next[i] - i;
            long total = (long)(l * r) % mod;
            answer = (answer + (total * arr[i]) % mod) % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
    void previousSmaller(int[] arr, int prev[]){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        prev[0] = -1;
        for(int i = 1; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prev[i] = st.peek();
            } else {
                prev[i] = -1;
            }
            
            st.push(i);
        }
    }
    void nextSmaller(int[] arr, int next[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        next[n - 1] = n;
        for(int i = n - 2; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                //System.out.println(st.peek());
                next[i] = st.peek();
            } else {
                next[i] = n;
            }
            
            st.push(i);
        }
    }
}
