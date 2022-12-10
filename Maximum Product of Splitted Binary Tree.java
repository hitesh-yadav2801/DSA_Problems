// Using extra space



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
    public int maxProduct(TreeNode root) {
        long result = 0;
        long m = 1000000007;
        long maxRes = Long.MIN_VALUE;
        ArrayList<Long> ans = new ArrayList<>();
        long sum = totalSum(root, ans);
        for(int i = 0; i < ans.size()-1 ; i++){
            result = (sum - ans.get(i))* ans.get(i);
            maxRes = Math.max(result, maxRes);
        }
        return (int)(maxRes % m);
    }

    public long totalSum(TreeNode root, ArrayList<Long> ans){
        if(root == null) return 0;
        long l = totalSum(root.left, ans);
        long r = totalSum(root.right,ans);
        ans.add(l + r + root.val);
        return l + r + root.val;
    }
}
