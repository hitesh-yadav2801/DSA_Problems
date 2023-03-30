class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int a = 0;
        int b = a;
        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            a += satisfaction[i];
            b += a;
            ans = Math.max(b, ans);
        }
        return ans;
    }
}
