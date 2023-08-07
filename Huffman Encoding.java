class Solution {
    public void traverse(Node root, ArrayList<String> ans, String temp){
        if(root.left == null && root.right == null){
            ans.add(temp);
            return;
        }
        traverse(root.left, ans, temp + "0");
        traverse(root.right, ans, temp + "1");
    }
    public ArrayList<String> huffmanCodes(String s, int f[], int n)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < f.length; i++){
            pq.offer(new Node(f[i]));
        }
        while(pq.size() > 1){
            Node leftNode = pq.poll();
            Node rightNode = pq.poll();
            
            Node newNode = new Node(leftNode.val + rightNode.val);
            newNode.left = leftNode;
            newNode.right = rightNode;
            
            pq.offer(newNode);
        }
        Node rootNode = pq.poll();
        ArrayList<String> ans = new ArrayList<>();
        traverse(rootNode, ans, "");
        
        return ans;
    }
}
class Node implements Comparable<Node>{
    int val;
    Node left;
    Node right;
    
    Node(int val){
        this.val = val;
    }
    
    // Implementing Comparable class to compare the Node elements in PriorityQueue
    public int compareTo(Node p){
        if(this.val==p.val)
          return 1;
        return this.val-p.val;
    }
}
