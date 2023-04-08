/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Queue<Node> q = new LinkedList<>();
    HashMap<Node, Node> vis = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node temp = new Node(node.val);
        vis.put(node, temp);
        q.add(node);
        bfs(node);
        return temp;
        
    }
    private void bfs(Node node){
        while(!q.isEmpty()){
            Node dummy = q.poll();
            for(Node child : dummy.neighbors){
                if(!vis.containsKey(child)){
                    vis.put(child, new Node(child.val));
                    q.add(child);
                }
                vis.get(dummy).neighbors.add(vis.get(child));
            }
        }
    }
}
