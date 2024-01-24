class Solution {
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new int[10]);
        return count;
    }

    void dfs(TreeNode root, int[] freq) {
        if(root == null){
            return;
        }
        freq[root.val]++;
        if(root.left == null && root.right == null){
            checkPalindrome(freq);
        }
        dfs(root.left, freq);
        dfs(root.right, freq);
        freq[root.val]--;
    }

    void checkPalindrome(int[] freq) {
        int odd = 0;
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " : " + freq[i]);
            if (freq[i] % 2 != 0) {
                odd++;
            }
        }
        if (odd <= 1) count++;
    }
}
