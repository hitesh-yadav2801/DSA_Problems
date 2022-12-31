// recursion + memoization with HashMap
// Slow solution
class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        return path(0, 0, m-1, n-1, map);
    }
    public int path(int s1, int s2, int d1, int d2, HashMap<String, Integer> map){
        if(s1 == d1 && s2 ==d2){
            return 1;
        } 
        if(s1 > d1 || s2 > d2){
            return 0;
        }

        String key = s1 + "Hitesh" + s2;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int path1 = path(s1, s2+1, d1, d2, map);
        int path2 = path(s1+1, s2, d1, d2, map);
        map.put(key , path1 + path2);
        
        return path1 + path2;
    }
}


// better dp solution

class Solution {
    public int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];
      for(int i=0;i<m;i++){
        dp[i][n-1] = 1;
      }
      for(int i=0;i<n;i++){
        dp[m-1][i] = 1;
      }
      for(int i=m-2;i>=0;i--){
        for(int j=n-2;j>=0;j--){
            dp[i][j] = dp[i+1][j] + dp[i][j+1];
        }
      }
      return dp[0][0];
    }
}
