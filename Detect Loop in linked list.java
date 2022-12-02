
//User function template for JAVA

/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/


class Solution {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
       Set<Node> set = new HashSet<>();
       Node temp = head;
       while(temp != null){
           if(set.contains(temp)){
               return true;
           }
           else{
               set.add(temp);
               temp = temp.next;
           }
       }
       return false;
    }
}
