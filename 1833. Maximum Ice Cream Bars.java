class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int[] count = new int[100001];
        for(int i=0;i<n;i++){
            count[costs[i]]++;
        }
        int ans = 0;
        for(int i=0;i<100001;i++){
            if(coins < i) return ans;

            for(int j=1; j<=count[i]; j++){
                if(coins < i) return ans;
                ans++;
                coins -= i;
            }
        }
        return ans;
    }
}
