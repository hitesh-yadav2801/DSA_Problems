class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(A[i], i);
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j <=i; j++){
                int idx = map.get(B[j]);
                if(idx <= i){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
