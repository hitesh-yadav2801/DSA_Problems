// Brute force solution
class KthLargest {
    List<Integer> num;
    int x;
    public KthLargest(int k, int[] nums) {
        num = new ArrayList<>();
        x = k;
        for(int i = 0; i < nums.length; i++){
            num.add(nums[i]);
        }
    }
    
    public int add(int val) {
        num.add(val);
        Collections.sort(num);
        return num.get(num.size() - x);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
