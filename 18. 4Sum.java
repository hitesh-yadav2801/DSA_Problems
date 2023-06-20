// Optimal Approach


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                if(sum < target){
                    left++;
                } else if(sum > target){
                    right--;
                } else {
                    // List<Integer> temp = new ArrayList<>();
                    // temp.add(nums[i]);
                    // temp.add(nums[j]);
                    // temp.add(nums[left]);
                    // temp.add(nums[right]);
                    list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return list;
    }
}
