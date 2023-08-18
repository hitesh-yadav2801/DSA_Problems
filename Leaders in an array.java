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

// without stack 
class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int nums[], int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = nums[n - 1];
        ans.add(max);
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] >= max){
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
