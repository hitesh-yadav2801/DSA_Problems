/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
  if(head == null || head.next == null) return head; 
  Node dummy = null;
  Node temp = head;
  head = head.next;
  while(head != null){
      temp.next = dummy;
      temp.prev = head;
      dummy = temp;
      temp = head;
      head = head.next;
  }
  temp.next = dummy;
  temp.prev = null;
  return temp;

}

// Prasoon code

public static Node reverseDLL(Node  head)
{
    Node curr = null;
    while(head!=null){
        Node next = head.next;
        head.next = curr;
        head.prev = next;
        curr = head;
        head = next;
     }
    return curr;
}
