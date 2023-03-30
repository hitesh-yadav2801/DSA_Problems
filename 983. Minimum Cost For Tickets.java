// Recursive solution(Gives TLE)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
       int ans = recursion(days, costs, 0);
       return ans; 
    }
    private int recursion(int[] days, int[] costs, int i){
        if(i >= days.length) return 0;
        int op1 = costs[0] + recursion(days, costs, i + 1);

        int k = i;
        for (; k < days.length; k++){
            if(days[k] >= days[i] + 7){
                break;
            }
        }
        int op2 = costs[1] + recursion(days, costs, k);

        for (; k < days.length; k++){
            if(days[k] >= days[i] + 30){
                break;
            }
        }
        int op3 = costs[2] + recursion(days, costs, k);

        return Math.min(op1, Math.min(op2, op3));
    }
}
