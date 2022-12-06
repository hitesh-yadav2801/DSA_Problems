/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/


class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
       if(head == null || head.next == null) return head;
       Node cur = head.next.next;
       Node prev = head;
       head = head.next;
       head.next = prev;
       
       while(cur != null && cur.next != null){
           prev.next = cur.next;
           Node temp = cur.next.next;
           cur.next.next = cur;
           prev = cur;
           cur = temp;
       }
       prev.next = cur;
       return head;
    }
}
