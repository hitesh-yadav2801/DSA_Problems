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

// Not optimal Soultion O(n2) TC and extra space of  o(n)
class Solution {
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> ansList = new ArrayList<>();
        inOrder(root, ansList);
        for(int i = 0; i < ansList.size() - 1; i++){
            int diff = ansList.get(i + 1) - ansList.get(i);
            System.out.println(diff);
            min = Math.min(min, diff);
        }
        return min;
    }
    private void inOrder(TreeNode root, ArrayList<Integer> ansList){
        if(root == null){
            return;
        }
        inOrder(root.left, ansList);
        ansList.add(root.val);
        inOrder(root.right, ansList);
    }
}
