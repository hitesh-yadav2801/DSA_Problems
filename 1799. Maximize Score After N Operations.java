class Solution {
    public int maxScore(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        HashMap<String, Integer> map = new HashMap<>();
        return solve(nums, vis, 1, map);
    }
    private int solve(int[] nums, boolean[] vis, int operation, HashMap<String, Integer> map){
        String key = Arrays.toString(vis) +"|" + operation;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int maxScore = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(vis[i] == true) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(vis[j] == true) continue;
                vis[i] = true;
                vis[j] = true;
                int score = operation * gcd(nums[i], nums[j]);
                int remScore = solve(nums, vis, operation + 1, map);
                vis[i] = false;
                vis[j] = false;
                maxScore = Math.max(maxScore, score + remScore);
            }
        }
        map.put(key, maxScore);
        return maxScore;
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
