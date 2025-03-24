class Solution {
    public int countDays(int days, int[][] nums) {
        int n = nums.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        
        for(int i = 0; i < n; i++){
            if(ans.isEmpty() || nums[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(nums[i]);
            } else {
                int[] last = ans.get(ans.size() - 1);
                last[1] = Math.max(last[1], nums[i][1]);
            }
        }
        
        int count = 0;
        n = ans.size();
        
        for(int i = 0; i < n; i++){
            if(i == 0){
                count += ans.get(i)[0] - 1;
            } else {
                count += ans.get(i)[0] - ans.get(i-1)[1] - 1;
            }
        }
        count += days - ans.get(n-1)[1];
        
        return count;
    }
}
