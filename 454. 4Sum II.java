// Brute force O(n^4)

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                for(int k : nums3)
                    for(int l : nums4)
                        if(i + j + k + l == 0) count++;
        return count;
    }
}

// Slightly better approach but still TLE ( O(n^3) )

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for(int i : nums2){
            for(int j : nums3){
                for(int k : nums4){
                    if(map.containsKey(-(i + j + k))){
                        count += map.get(-(i + j + k));
                    }
                }
            }
        }
        return count;
    }
}

// Optimal Approach O(n^2)

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            for(int j : nums2){
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int count = 0;
        for(int i : nums3){
            for(int j : nums4){
                if(map.containsKey(-(i + j))){
                    count += map.get(-(i + j));
                }
            }
        }
        return count;
    }
}
