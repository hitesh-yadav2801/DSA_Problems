class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] answer = new int[queries.length];
        int i = -1;
        int sum = 0;
        map.put(0, 0);
        while(i < nums.length - 1){
            i++;
            sum += nums[i];
            map.put(sum, i+1);
        }
        for(int j=0;j<queries.length;j++){
            Map.Entry<Integer, Integer> entry = 
            map.floorEntry(queries[j]);
            if(entry != null){
                answer[j] = entry.getValue();
            }
        }
        return answer;
    }
}
