// used only recusion(No dp)
// gives tle
class Solution {
    public long mostPoints(int[][] questions) {
        long res = rec(questions, 0);
        return res;
    }
    private long rec(int[][] questions, int idx){
        int len = questions.length;
        if(idx >= len){
            return 0;
        }

        long taken = questions[idx][0] + 
        rec(questions, idx + questions[idx][1] + 1);
        long not_taken = rec(questions, idx + 1);

        return Math.max(taken, not_taken);
    }
}
