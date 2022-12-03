

/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class GfG
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	
    	int count = 0;
    	Node dummy = head;
    	Node temp = head;
    	while(head != null){
    	    head = head.next;
    	    count++;
    	}
    	if(count < n) return -1;
    	for(int i =0;i<n;i++){
    	    dummy = dummy.next;
    	}
    	while(dummy != null){
    	    dummy = dummy.next;
    	    temp = temp.next;
    	}
    	return temp.data;
    }
}
