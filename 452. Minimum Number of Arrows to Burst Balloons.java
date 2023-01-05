class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        long end = points[0][1];
        int res = 1;
        int i = 0;
        while(i<= points.length-1){
           if(end < points[i][0]){
               res++;
               end = points[i][1];
           }
           i++;
        }
        return res;
    }
}
