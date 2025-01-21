class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int len = m * n;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowFreq = new int[m];
        int[] colFreq = new int[n];
        for(int i = 0; i < len; i++){
            int[] pair = map.get(arr[i]);
            rowFreq[pair[0]]++;
            colFreq[pair[1]]++;
            if(rowFreq[pair[0]] == n || colFreq[pair[1]] == m){
                return i;
            }
        }
        return 0;
    }
}
