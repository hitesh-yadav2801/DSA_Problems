class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            if(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i >= k - 1){
                ans[j++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
