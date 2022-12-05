/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
       int carry = addCarry(head);
       if(carry > 0){
           Node newNode = new Node(carry);
           newNode.next = head;
           return newNode;
       } else {
          return head; 
       }
    }
    public static int addCarry(Node head){
        if(head == null) return 1;
        int res = head.data + addCarry(head.next);
        head.data = res % 10;
        return res/10;
    }
}
