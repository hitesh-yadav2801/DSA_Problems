class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);

        for(int i = 1; i <= rowIndex; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < i; j++){
                int num = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                temp.add(num);
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans.get(rowIndex);
    }
}
