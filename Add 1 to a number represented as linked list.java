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

// using reverse function

class Solution
{
    public static Node addOne(Node head) 
    { 
        Node revHead = reverse(head);
        Node temp = revHead, prev = null;
        int carry = 1;
        while(temp != null){
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            prev = temp;
            temp = temp.next;
        }
        if(carry != 0){
            prev.next = new Node(carry);
        }
        return reverse(revHead);
    }
    public static Node reverse(Node head){
        Node temp = head, prev = null;
        while(head != null){
            head = head.next;
            temp.next = prev;
            prev = temp;
            temp = head;
        }
        return prev;
    }
}
