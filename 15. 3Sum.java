// Brute force(TLE)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if(!list.contains(temp)){
                            list.add(temp);
                        }
                        continue;
                    }
                }
            }
        }
        return list;
    }
}

// Better approach using set

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i + 1; j < n; j++){
                int sum = -1 * (nums[i] + nums[j]);
                if(set.contains(sum)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(sum);
                    temp.add(nums[j]);
                    if(!s.contains(temp)){
                        s.add(temp);
                        list.add(temp);
                    }
                }
                set.add(nums[j]);
            }
        }
        return list;
    }
}

// 2 pointers method

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    set.add(temp);
                    j++;
                    k--;
                } else if(sum < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
        list.addAll(set);
        return list;
    }
}

// 2 pointers without HashSet

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    list.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                } else if(sum < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }
}
