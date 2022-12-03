//function Template for Java

/* linked list node class:

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        Node temp = head;
        Node prev = null;
        while(head != null){
            head = head.next;
            temp.next = prev; 
            prev = temp;
            temp = head;
        }
        return prev;
    }
}
