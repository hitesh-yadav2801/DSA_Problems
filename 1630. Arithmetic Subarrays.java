class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            int len = r[i] - l[i] + 1;
            int subArr[] = new int[len];
            int k = l[i];
            for(int j = 0; j < len; j++){
                subArr[j] = nums[k++];
            }
            if(solve(subArr)){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
    public boolean solve(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; i++){
            int diff = arr[i+1] - arr[i];
            if(diff != difference){
                return false;
            }
        }
        return true;
    }
}
