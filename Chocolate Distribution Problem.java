class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long min = Integer.MAX_VALUE;
        int left = 0, right = m - 1;
        while(right < n){
            long diff = a.get(right++) - a.get(left++);
            min = Math.min(min, diff);
        }
        return min;
    }
}
