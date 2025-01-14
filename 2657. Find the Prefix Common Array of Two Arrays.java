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


// O(N) tc

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];
        int count = 0;
        for(int i = 0; i < n ; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                count++;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
