class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            ans.add(new ArrayList<>());
        }
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }
        for(int i : set1){
            if(!set2.contains(i)){
                ans.get(0).add(i);
            }
        }
        for(int i : set2){
            if(!set1.contains(i)){
                ans.get(1).add(i);
            }
        }
        return ans;
    }
}
