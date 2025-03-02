class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(nums1[i][0] == nums2[j][0]){
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if(nums1[i][0] < nums2[j][0]){
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        while(i < n1){
            list.add(nums1[i]);
            i++;
        }
        while(j < n2){
            list.add(nums2[j]);
            j++;
        }
        int[][] ans = new int[list.size()][2];
        for(i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
