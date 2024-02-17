class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq);
        int ans = 0;
        for(int i = 0; i < freq.size(); i++){
            if(freq.get(i) <= k){
                k -= freq.get(i);
            } else {
                return freq.size() - i;
            }
        }
        return 0;
    }
}
