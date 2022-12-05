/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
        Node temp = head;
        Node dummy = null;
        Set<Integer> set = new HashSet<>();
        while(temp != null){
               if(set.contains(temp.data)){
                       dummy.next = temp.next;
               } else{
                   set.add(temp.data);
                   dummy = temp;
               }   
               temp = dummy.next;
        }
        return head;
    }
}
