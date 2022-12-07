// Using inOrder traversal


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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }
    void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}

// Using simple recursion

class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return sum;
    }
}
