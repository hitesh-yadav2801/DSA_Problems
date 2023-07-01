class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        rec(cookies, 0, k, new int[k]);
        return ans;
    }
    private void rec(int[] cookies, int idx, int k, int[] temp){
        if(idx >= cookies.length){
            int unfairness = 0;
            for(int x : temp){
                unfairness = Math.max(x, unfairness);
            }
            ans = Math.min(ans, unfairness);
            return;
        }
        int cookie = cookies[idx];
        for(int i = 0; i < k; i++){
            temp[i] += cookie;
            rec(cookies, idx + 1, k, temp);
            temp[i] -= cookie;
        }
    }
}
