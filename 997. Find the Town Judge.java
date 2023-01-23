class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n+1];
        int[] out = new int[n+1];
        for(int i=0;i<trust.length;i++){
            in[trust[i][1]]++;
            out[trust[i][0]]++;
        }
        for(int i=1;i<=n;i++){
            if(in[i] == n-1){
                if(out[i] == 0){
                    return i;
                }
            }
        }
        return -1;
    }
}

// Another method

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for(int i=0;i<trust.length;i++){
            count[trust[i][0]]--;
            count[trust[i][1]]++;
        }
        for(int i=1;i<=n;i++){
            if(count[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
