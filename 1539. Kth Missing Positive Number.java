class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> map = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            map.add(arr[i]);
        }
        int i = 0;
        int temp = k;
        for(; i <= 1000 + temp && k >= 0; i++){
            if(map.contains(i)){
                continue;
            } else {
                k--;
            }
        }
        return i - 1;
    }
}
