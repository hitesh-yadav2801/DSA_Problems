/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
       if(root == null){
           return 0;
       } 
       return diff(root, root.val, root.val);
    }
    int diff(TreeNode root, int curMin, int curMax){
        if(root == null){
            return curMax - curMin;
        }
        curMax = Math.max(root.val, curMax);
        curMin = Math.min(root.val, curMin);

        int l = diff(root.left, curMin, curMax);
        int r = diff(root.right, curMin, curMax);

        return Math.max(l,r);
    }
}
