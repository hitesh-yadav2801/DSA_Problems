// Using Hashmap

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int n = nums.length / 3;
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq > n){
                list.add(key);
            }
        }
        return list;
    }
}
