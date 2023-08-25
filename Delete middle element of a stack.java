class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int size){
        int mid = size / 2;
        solve(s, mid, 0);
    } 
    void solve(Stack<Integer>s, int mid, int cur){
        if(cur == mid){
            s.pop();
            return;
        }
        
        int temp = s.pop();
        cur++;
        solve(s, mid, cur);
        s.push(temp);
    }
}

