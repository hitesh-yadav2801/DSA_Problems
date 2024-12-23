class Solution {
    public int minimumOperations(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                temp.add(cur.val);
            }
            count += countMinOperations(temp);

        }
        return count;
    }
    private int countMinOperations(List<Integer> temp){
        List<Integer> sortedList = new ArrayList<>(temp);
        Collections.sort(sortedList);
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < temp.size(); i++){
            map.put(temp.get(i), i);
        }
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) != sortedList.get(i)){
                count++;
                int targetValue = sortedList.get(i);
                int curPos = map.get(targetValue);

                Collections.swap(temp, i, curPos);

                map.put(temp.get(curPos), curPos);
                map.put(targetValue, i);
            }
        }
        return count;
    }
}
