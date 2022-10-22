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

// using recursion

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(ans, root);
        return ans;
    }
    private void inOrder(List<Integer> ans, TreeNode root){
        if(root == null) return;
        inOrder(ans, root.left);
        ans.add(root.val);
        inOrder(ans, root.right);
    }
}
