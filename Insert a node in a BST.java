// User function Template for Java

class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        // if(root == null){
        //   root = new Node(Key);
        //   return root;
        // } 
        // Node cur = root;
        // Node parent = null;
        // while(cur != null){
        //     if(Key < cur.data){
        //         parent = cur;
        //         cur = cur.left;
        //     } else if(Key > cur.data){
        //         parent = cur;
        //         cur = cur.right;
        //     }
        // }
        // if(Key < parent.data){
        //     parent.left = new Node(Key);
        // } 
        // if(Key > parent.data){
        //     parent.right = new Node(Key);
        // }
        // return root;
        if(root == null){
            root = new Node(Key);
            return root;
        }
        if(Key > root.data){
            root.right = insert(root.right, Key);
        }else if (Key < root.data){
            root.left = insert(root.left, Key);
        }  
        return root;
    }
}
