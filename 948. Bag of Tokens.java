class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxScore = 0, curScore = 0;
        int left = 0, right = tokens.length - 1;
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left];
                curScore++;
                left++;
                maxScore = Math.max(maxScore, curScore);
            } else if(power < tokens[left] && curScore > 0){
                power += tokens[right];
                curScore--;
                right--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
