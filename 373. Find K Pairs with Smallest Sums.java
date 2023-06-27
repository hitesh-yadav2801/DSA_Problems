// Brute force 

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                pq.offer(new int[]{nums1[i] + nums2[j], i, j});
            }
        }
        while(k-- > 0 && !pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int[] arr = pq.peek();
            temp.add(nums1[arr[1]]);
            temp.add(nums2[arr[2]]);
            pq.poll();
            ans.add(temp);
        }
        return ans;
    } 
}
