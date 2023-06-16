class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(!list.isEmpty() && end <= list.get(list.size() - 1).get(1)){
                continue;
            }
            for(int j = i + 1; j < n; j++){
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            list.add(Arrays.asList(start, end));
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}
