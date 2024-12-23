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
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }
    TreeNode solve(int[] nums, int left, int right){
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        TreeNode leftTree = solve(nums, left, mid - 1);
        TreeNode rightTree = solve(nums, mid + 1, right);
        newNode.left = leftTree;
        newNode.right = rightTree;

        return newNode;
    }
}