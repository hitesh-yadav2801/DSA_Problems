class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
      HashSet<Integer> set = new HashSet<>();
        int cs = 0;
        set.add(0);
        for(int e : arr){
            cs += e;
            if(set.contains(cs)) return true;
            set.add(cs);
        }
        return false;
    }
}
