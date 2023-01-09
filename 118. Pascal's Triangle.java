class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0) return ans;
        ans.add(new ArrayList<>());       
        ans.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                int dummy = ans.get(i-1).get(j-1) +
                ans.get(i-1).get(j);
                temp.add(dummy);
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}

// Recursive solution

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
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root != null){
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        }
        return list;
    }
}
