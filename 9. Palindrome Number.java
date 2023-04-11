class Solution {
    public boolean isPalindrome(int x) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        if(x < 0) return false;
        while( x != 0){
            int rem = x % 10;
            x = x / 10;
            st.push(rem);
            q.offer(rem);
        }
        while(!q.isEmpty() && !st.isEmpty()){
            int a = st.pop();
            int b = q.poll();
            if(a != b){
                return false;
            }
        }
        return true;
    }
}
