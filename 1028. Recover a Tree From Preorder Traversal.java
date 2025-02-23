class Solution {
    int n, idx;
    public TreeNode recoverFromPreorder(String s) {
        n = s.length();
        idx = 0;
        return solve(s, 0);
    }
    TreeNode solve(String s, int depth){
        if(idx >= n){
            return null;
        }
        int j = idx;
        while(j < n && s.charAt(j) == '-'){
            j++;
        }
        int dash = j - idx;
        if(depth != dash){
            return null;
        }
        idx = j;
        int num = 0;
        while(idx < n && Character.isDigit(s.charAt(idx))){
            num = (num * 10) + (s.charAt(idx) - '0');
            idx++;
        }
        TreeNode newNode = new TreeNode(num);
        newNode.left = solve(s, depth + 1);
        newNode.right = solve(s, depth + 1);

        return newNode;
    }
}
