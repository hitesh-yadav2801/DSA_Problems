// Greedy solution O(n) time and O(1) space
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if((totalGas - totalCost) < 0) return -1;
        int rem = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            rem = rem + gas[i] - cost[i];
            if(rem < 0){
                start = i + 1;
                rem = 0;
            } 
        }
        return start;
    }
}
