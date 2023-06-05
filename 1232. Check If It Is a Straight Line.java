class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        for(int i = 2; i < coordinates.length; i++){
            int a1 = coordinates[i][0];
            int b1 = coordinates[i][1];
            int a = (y2-y1)*(a1-x1);
            int b = (b1-y1)*(x2-x1);
            if(a != b){
                return false;
            }
        }
        return true;
    }
}
