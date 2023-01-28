class SummaryRanges {
    TreeSet<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
      set.add(value);  
    }
    
    public int[][] getIntervals() {
        if(set.isEmpty()){
            return new int[0][];
        }
        List<int[]> ans = new ArrayList<>();
        int start = set.first();
        int end = set.first();
        for(int s : set){
            if(s == start){
                continue;
            } else if(s == end + 1){
                end = s;
            } else{
                ans.add(new int[]{start, end});
                start = end = s;
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
