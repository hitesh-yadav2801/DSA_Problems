// O(n) TC and SC
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxScore = Integer.MIN_VALUE;
        int[] sum = new int[n];
        int[] minus = new int[n];
        for(int i = 0; i < n; i++){
            sum[i] = values[i] + i;
            minus[i] = values[i] - i;
        }
        for(int i = 1; i < n; i++){
            sum[i] = Math.max(sum[i], sum[i-1]);
        }
        for(int j = n-2; j >= 0; j--){
            minus[j] = Math.max(minus[j], minus[j+1]);
        }
        for(int i = 0; i < n - 1; i++){
            maxScore = Math.max(maxScore, sum[i] + minus[i+1]);
        }
        return maxScore;
    }
}


// O(n) TC and O(1) SC

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxScore = 0;
        int first = values[0] + 0;

        for(int i = 1; i < n; i++){
            int second = values[i] - i;
            maxScore = Math.max(maxScore, first + second);
            first = Math.max(first, values[i] + i);
        }
        return maxScore;
    }
}
