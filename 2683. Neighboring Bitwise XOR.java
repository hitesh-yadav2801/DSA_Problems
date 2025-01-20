class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = derived[0];
        for(int i = 1; i < n; i++){
            original[i] = original[i - 1] ^ derived[i - 1];
        }  
        if((original[n - 1] ^ derived[n - 1]) == original[0]){
            return true;
        }
        return false;
    }
}
