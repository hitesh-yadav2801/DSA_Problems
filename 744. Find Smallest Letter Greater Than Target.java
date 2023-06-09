// o(n)

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(int i = 0; i < letters.length; i++){
            if(letters[i] > target){
                return letters[i];
            }
        }
        return letters[0];
    }
}

// O(logN) binary search

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int r = n - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(letters[mid] <= target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l == n ? letters[0] : letters[l];
    }
}
