// Using extra space
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

// Without using any extra space

class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}

// optimal
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = 0;
        int temp = x;
        while(x > 0){
            int rem = x % 10;
            num = num * 10 + rem;
            x /= 10;
        }
        if(temp == num) return true;
        return false;
    }
}
