class Solution {
    public int[] asteroidCollision(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int num : nums){
            while(!st.isEmpty() && num < 0 && st.peek() > 0){
                int sum = num + st.peek();
                if(sum < 0){
                    st.pop();
                } else if(sum > 0){
                    num = 0;
                } else {
                    st.pop();
                    num = 0;
                }
            }
            if(num != 0){
                st.push(num);
            }
        }
        int len = st.size();
        int[] ans = new int[len];
        for(int i = len - 1; i >= 0; i--){
            ans[i] = st.peek();
            st.pop();
        }
        return ans;
    }
}
