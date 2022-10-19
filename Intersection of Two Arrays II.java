// using HashMap

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(map.get(nums1[i]) != null){
                map.put(nums1[i] , map.get(nums1[i]) +1);
            } else{
                map.put(nums1[i] , 1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(map.get(nums2[i]) != null && map.get(nums2[i]) != 0){
                list.add(nums2[i]);
                map.put(nums2[i] , map.get(nums2[i]) -1);
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}


// using Hashset


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }
        set2.retainAll(set1);
        
        int[] ans = new int[set2.size()];
        int i=0;
        for(int e : set2){
             ans[i++] = e;
        }
        return ans;
    }
}
