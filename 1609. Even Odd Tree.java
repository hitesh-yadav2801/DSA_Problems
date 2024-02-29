class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        int min = 0;
        int max = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(flag == true){
                    if(cur.val % 2 == 1){
                        if(cur.val <= min) return false;
                        min = cur.val;
                    } else {
                        return false;
                    }
                } else {
                    if(cur.val % 2 == 0){
                        if(cur.val >= max) return false;
                        max = cur.val;
                    } else {
                        return false;
                    }
                }

                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            min = 0;
            max = Integer.MAX_VALUE;
            flag = !flag;
            System.out.println(flag);
        }
        return true;
    }
}
