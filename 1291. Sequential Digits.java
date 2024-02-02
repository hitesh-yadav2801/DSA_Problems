class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < 9; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int top = q.poll();
            if(top >= low && top <= high) ans.add(top);
            int lastDigit = top % 10 + 1;
            if(lastDigit < 10){
                q.add(top * 10 + lastDigit);
            }
        } 
        return ans;
    }
}
