class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < matches.length; i++){
            int win = matches[i][0];
            int loss = matches[i][1];
            map1.put(win, map1.getOrDefault(win, 0) + 1);
            map2.put(loss, map2.getOrDefault(loss, 0) + 1);
        }
        List<Integer> winnerList = new ArrayList<>();
        List<Integer> loserList = new ArrayList<>();
        for(int key : map1.keySet()){
            if(!map2.containsKey(key)){
                winnerList.add(key);
            }
        }
        Collections.sort(winnerList);
        for(int key : map2.keySet()){
            if(map2.get(key) == 1){
                loserList.add(key);
            }
        }
        Collections.sort(loserList);
        ans.add(winnerList);
        ans.add(loserList);

        return ans;
    }
}
