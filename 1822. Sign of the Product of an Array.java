class Solution {
    public int arraySign(int[] nums) {
        int count = 0;
        int flag = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                count++;
            } if(nums[i] == 0){
                flag = 1;
            }
        }
        if(count % 2 == 0 && flag == 0){
            return 1;
        } else if(count % 2 != 0 && flag == 0){
            return -1;
        }
        return 0;
    }
}
