class Solution {
    int leftSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        solve(root, false);
        return leftSum;
    }
    void solve(TreeNode root, boolean left){
        if(root.left == null && root.right == null){
            if(left){
                leftSum += root.val;
            }
            return;
        }
        if(root.left != null){
            solve(root.left, true);
        } 
        if(root.right != null){
            solve(root.right, false);
        }
    }
}
