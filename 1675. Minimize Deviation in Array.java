class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : nums){
            if(i % 2 == 1){
                set.add(i * 2);
            } else {
                set.add(i);
            }
        }
        int diff =  Integer.MAX_VALUE;
        while(true){
            int max = set.last();
            int min = set.first();
            int curDiff = max - min;
            diff = Math.min(diff, curDiff);
            if(max % 2 == 0){
                set.remove(max);
                set.add(max / 2);

            } else {
                // terminal state
                return diff;
            }
        }
    }
}
