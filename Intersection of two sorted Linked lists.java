/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
     Node temp = new Node(0);
     Node dummy = temp;
    
     while(head1 != null && head2 != null){
         if(head1.data == head2.data){
             temp.next = new Node(head1.data);
             temp = temp.next;
             head1 = head1.next;
             head2 = head2.next;
         } else if(head1.data < head2.data){
             head1 = head1.next;
         }  else if(head1.data > head2.data){
             head2 = head2.next;
         }
     }
     return dummy.next;
    }
}
