class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            for(int i = 0; i < top.freq; i++){
                sb.append(top.ch);
            }
        }
        return sb.toString();
    }
    class Pair{
        char ch;
        int freq;

        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}
