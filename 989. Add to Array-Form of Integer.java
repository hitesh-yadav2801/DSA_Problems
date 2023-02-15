class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = n - 1;
        while(i >= 0 || k > 0){
            if(i >= 0){
                k += num[i];
            }
            ans.add(k % 10);
            k = k / 10;
            i--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
