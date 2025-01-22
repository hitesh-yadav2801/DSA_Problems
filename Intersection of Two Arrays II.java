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


// 

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                temp.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] ans = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}

// Optimal solution O(NlogN) TC:

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for(int k = 0; k < list.size(); k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}
