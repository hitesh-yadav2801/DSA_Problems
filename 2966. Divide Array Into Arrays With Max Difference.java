class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        boolean flag = false;
        for(int i = 0; i < n; i+=3){
            if(nums[i+2] - nums[i] > k){
                flag = true;
            }
        }
        if(flag){
            return new int[0][0];
        } 
        int[][] ans = new int[n / 3][3];
        for(int i = 0; i < n; i++){
            ans[i/3][i%3] = nums[i];
        }
        return ans;
    }
}


// more concise

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[0][0];
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i+=3){
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }
            int[] triplet = {nums[i], nums[i+1], nums[i+2]};
            ans = Arrays.copyOf(ans, ans.length + 1);
            ans[ans.length - 1] = triplet;
        }
        return ans;
    }
}
