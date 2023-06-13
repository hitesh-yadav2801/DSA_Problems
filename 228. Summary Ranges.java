class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1] + 1){
                end = nums[i];
                continue;
            } else {
                if(start == end){
                    list.add(""+start);
                } else {
                    list.add(""+start+"->"+ end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if(start == end){
            list.add(""+start);
        } else {
            list.add(""+start+"->"+ end);
        }
        return list;
    } 
}


// More neat and clean code

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            while(i+1 < nums.length && nums[i] + 1 == nums[i+1]){
                i++;
            }
            if(start != nums[i]){
                list.add(""+start+"->"+nums[i]);
            } else {
                list.add(""+start);
            }
        }
        return list;
    }
}
