import java.util.*;

class Solution {
    Map<Integer, TreeNode> parent;
    
    private void bfs(TreeNode target, int k, List<Integer> ans){
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        
        q.add(target);
        vis.add(target.val);
        
        while(!q.isEmpty()){
            int n = q.size();
            
            if(k == 0){
                break;
            }
            while(n-- > 0){
                TreeNode cur = q.peek();
                q.poll();
                if(cur.left != null && !vis.contains(cur.left.val)){
                    q.add(cur.left);
                    vis.add(cur.left.val);
                }
                if(cur.right != null && !vis.contains(cur.right.val)){
                    q.add(cur.right);
                    vis.add(cur.right.val);
                }
                TreeNode par = parent.get(cur.val);
                if(par != null && !vis.contains(par.val)){
                    q.add(par);
                    vis.add(par.val);
                }
            }
            k--;
        }
        
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        buildParentMap(root, null);
        List<Integer> ans = new ArrayList<>();
        bfs(target, k, ans);
        return ans;
    }
    
    public void buildParentMap(TreeNode node, TreeNode par){
        if(node == null) return;
        parent.put(node.val, par);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}
