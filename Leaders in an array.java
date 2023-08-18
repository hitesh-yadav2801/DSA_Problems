class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int nums[], int n){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st.push(nums[n - 1]);
        int i = n - 2;
        while(i >= 0){
            if(nums[i] >= st.peek()){
                ans.add(st.pop());
                st.push(nums[i]);
            }
            i--;
        }
        ans.add(st.pop());
        Collections.reverse(ans);
        return ans;
    }
}
