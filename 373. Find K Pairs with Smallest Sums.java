// Brute force  TLE

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


// Small Optimization

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int sum = nums1[i] + nums2[j];
                if(pq.size() < k){
                    pq.offer(new int[]{sum, nums1[i], nums2[j]});
                } else if(pq.peek()[0] > sum){
                    pq.poll();
                    pq.offer(new int[]{sum, nums1[i], nums2[j]});
                } else {
                    break;
                }
            }
        }
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int[] arr = pq.peek();
            temp.add(arr[1]);
            temp.add(arr[2]);
            pq.poll();
            ans.add(temp);
        }
        return ans; 
    } 
}


// Optimized Approach

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<String> vis = new HashSet<>();
        int sum = nums1[0] + nums2[0];
        pq.offer(new int[]{sum, 0, 0});
        vis.add(0 + "-" + 0);

        while (k-- > 0 && !pq.isEmpty()) {
            int[] temp = pq.peek();
            pq.poll();
            int i = temp[1];
            int j = temp[2];
            ans.add(List.of(nums1[i], nums2[j]));

            if (j + 1 < n && !vis.contains(i + "-" + (j + 1))) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                vis.add(i + "-" + (j + 1));
            }
            if (i + 1 < m && !vis.contains((i + 1) + "-" + j)) {
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                vis.add((i + 1) + "-" + j);
            }
        }

        return ans;
    }
}
