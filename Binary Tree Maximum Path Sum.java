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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans; 
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if(l + root.val > ans){
            ans = l + root.val;
        }
        if(r + root.val > ans){
           ans = r + root.val;
        }
        if(l + r + root.val > ans){
           ans = l + r + root.val;
        } 
        if(root.val > ans){
           ans = root.val;
        }
        return Math.max(Math.max(l + root.val, r + root.val), 
            root.val);
    }
}
