class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
       //  for(int i=0;i<n-1;i++){
       //      for(int j=i+1;j<n;j++){
       //          if(nums[i] == nums[j]){
       //              return true;
       //          }
       //      }          
       //  }
       //  return false; 
        
        
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        if(set.size() < nums.length){
            return true;
        } else{
            return false;
        }       
        
        
    }
}
